package by.zhuk.bdam.executor;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.SparkJobConfig;
import by.zhuk.bdam.exception.SparkJobExecuteException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SparkJobExecutor implements JobExecutor {
    private static Logger logger = LogManager.getLogger(SparkJobExecutor.class);

    @Override
    public String executeJob(JobConfig config) throws SparkJobExecuteException {
        if (!(config instanceof SparkJobConfig)) {
            throw new SparkJobExecuteException("Config is not instance of by.zhuk.bdam.domain.SparkJobConfig");
        }
        SparkJobConfig sparkJobConfig = (SparkJobConfig) config;
        SparkLauncher spark = new SparkLauncher()
                .setVerbose(sparkJobConfig.isVerbose())
                .setDeployMode(sparkJobConfig.getMode().toString().toLowerCase())
                .setJavaHome(sparkJobConfig.getJavaHome())
                .setMainClass(sparkJobConfig.getMainClass())
                .setSparkHome(sparkJobConfig.getSparkHome())
                .setAppResource(sparkJobConfig.getAppPath())
                .setMaster(sparkJobConfig.getMaster())
                .addAppArgs(sparkJobConfig.getArgsList().toArray(new String[0]));

        for (Map.Entry<String, String> entry : sparkJobConfig.getSparkParams().entrySet()) {
            spark = spark.setConf(entry.getKey(), entry.getValue());
        }
        try {
            SparkAppHandle handle = spark.startApplication();
            while (!(handle.getState().equals(SparkAppHandle.State.FINISHED) || handle.getState().equals(SparkAppHandle.State.FAILED) || handle.getState().equals(SparkAppHandle.State.KILLED))) {
                TimeUnit.SECONDS.sleep(4);
            }
            return handle.getAppId();
        } catch (IOException | InterruptedException e) {
            logger.error(e);
        }
        return null;
    }

}
