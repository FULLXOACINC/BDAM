package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.JobConfig;

import java.util.HashMap;
import java.util.Map;

public class SparkShuffleWriteProblemSolver implements ProblemSolver {

    @Override
    public String findTextSolution(JobConfig config) {
        return "gcc solution";
    }

    @Override
    public Map<String, String> findConfigSolution(JobConfig config) {
        return new HashMap<>();
    }
}
