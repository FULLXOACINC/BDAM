package by.zhuk.bdam.problemsolver.core;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;

import java.util.Map;

public interface AppProblemSolver<K> {
    Map<String,JobProblemSolution> solveProblems(K k, JobConfig config);
}
