package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;

import java.util.HashMap;
import java.util.Map;

public class SparkGcProblemSolver implements ProblemSolver {

    @Override
    public String findTextSolution(JobConfig config) {
        return "Gc solution";
    }

    @Override
    public Map<String, String> findConfigSolution(JobConfig config) {
        return new HashMap<>();
    }
}
