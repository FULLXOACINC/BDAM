package by.zhuk.bdam.problemsolver.core;

import by.zhuk.bdam.domain.JobConfig;

public interface AppProblemSolver<K, T> {
    T solveProblem(K k, JobConfig config);
}
