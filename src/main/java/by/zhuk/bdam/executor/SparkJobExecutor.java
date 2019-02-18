package by.zhuk.bdam.executor;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.SparkJobConfig;
import by.zhuk.bdam.exception.SparkJobExecuteException;

public class SparkJobExecutor implements JobExecutor {
    @Override
    public String executeJob(JobConfig config) throws SparkJobExecuteException {
        if(!(config instanceof SparkJobConfig)){
            throw new SparkJobExecuteException("Config is not instance of by.zhuk.bdam.domain.SparkJobConfig");
        }
        System.out.println("");
        return null;
    }

}
