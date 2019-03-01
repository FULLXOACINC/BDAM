package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.JobConfig;

public interface ProblemSolver<T> {
    T solve(JobConfig config);
}
