package by.zhuk.bdam.reconfiger;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.JobProblemSolution;
import by.zhuk.bdam.domain.SparkJobConfig;

public class SparkJobReconfiguer implements JobReconfiguer {
    @Override
    public void reconfigure(JobProblemSolution solution, JobConfig config) {
        ((SparkJobConfig) config).getSparkParams().putAll(solution.getConfig());
    }
}
