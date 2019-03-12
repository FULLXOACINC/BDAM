package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;

import java.util.HashMap;
import java.util.Map;

public class SparkSchedulerDelayProblemSolver implements ProblemSolver {

    @Override
    public String findTextSolution(JobConfig config) {
        return "SchedulerDelay solution";
    }

    @Override
    public Map<String, String> findConfigSolution(JobConfig config) {
        return new HashMap<>();
    }
}
