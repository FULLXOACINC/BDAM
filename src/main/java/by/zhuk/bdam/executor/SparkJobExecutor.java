package by.zhuk.bdam.executor;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.SparkJobConfig;
import by.zhuk.bdam.exception.JobExecuteException;
import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SparkJobExecutor implements JobExecutor {

    @Override
    public String executeJob(JobConfig config) throws JobExecuteException {
        if (!(config instanceof SparkJobConfig)) {
            throw new JobExecuteException("Config is not instance of by.zhuk.bdam.domain.SparkJobConfig");
        }
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n");
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
            throw new JobExecuteException(e);
        }
    }

}
