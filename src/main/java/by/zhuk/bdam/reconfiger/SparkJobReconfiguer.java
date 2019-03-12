package by.zhuk.bdam.reconfiger;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;
import by.zhuk.bdam.domain.spark.SparkJobConfig;

import java.util.Map;

public class SparkJobReconfiguer implements JobReconfiguer {

    @Override
    public void reconfigure(Map<String, JobProblemSolution> solutionMap, JobConfig config) {
        for (Map.Entry<String, JobProblemSolution> entry : solutionMap.entrySet()) {
            JobProblemSolution solution = entry.getValue();
            ((SparkJobConfig) config).getSparkParams().putAll(solution.getConfig());
        }
    }
}
