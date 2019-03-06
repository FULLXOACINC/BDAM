package by.zhuk.bdam.problemsolver.core;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;

public interface AppProblemSolver<K> {
    JobProblemSolution solveProblem(K k, JobConfig config);
}
