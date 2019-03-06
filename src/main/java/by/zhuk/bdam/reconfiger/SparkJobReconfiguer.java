package by.zhuk.bdam.reconfiger;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;
import by.zhuk.bdam.domain.spark.SparkJobConfig;

public class SparkJobReconfiguer implements JobReconfiguer {
    @Override
    public void reconfigure(JobProblemSolution solution, JobConfig config) {
        ((SparkJobConfig) config).getSparkParams().putAll(solution.getConfig());
    }
}
