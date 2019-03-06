package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;

import java.util.Map;

public interface ProblemSolver {
    String findTextSolution(JobConfig config);

    Map<String, String> findConfigSolution(JobConfig config);
}
