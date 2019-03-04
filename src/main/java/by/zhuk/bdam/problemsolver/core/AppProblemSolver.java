package by.zhuk.bdam.problemsolver.core;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.JobProblemSolution;

public interface AppProblemSolver<K> {
    JobProblemSolution solveProblem(K k, JobConfig config);
}
