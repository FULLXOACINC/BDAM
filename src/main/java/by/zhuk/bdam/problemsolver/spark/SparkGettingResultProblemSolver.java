package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;

import java.util.HashMap;
import java.util.Map;

public class SparkGettingResultProblemSolver implements ProblemSolver {

    @Override
    public String findTextSolution(JobConfig config) {
        return "GettingResult solution";
    }

    @Override
    public Map<String, String> findConfigSolution(JobConfig config) {
        return new HashMap<>();
    }
}