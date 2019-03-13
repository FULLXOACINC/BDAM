package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;

import java.util.List;
import java.util.Map;

public interface ProblemSolver {
    List<String> findTextSolutions(JobConfig config);

    Map<String, String> findConfigSolution(JobConfig config);
}
