package by.zhuk.bdam.executor;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.exception.JobExecuteException;

public interface JobExecutor {
    String executeJob(JobConfig config) throws JobExecuteException;
}
