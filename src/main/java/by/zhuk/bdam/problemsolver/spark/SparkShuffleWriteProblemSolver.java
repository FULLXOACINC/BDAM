package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparkShuffleWriteProblemSolver implements ProblemSolver {

    @Override
    public List<String> findTextSolutions(JobConfig config) {
        return Collections.singletonList("ShuffleWrite solution");
    }

    @Override
    public Map<String, String> findConfigSolution(JobConfig config) {
        return new HashMap<>();
    }
}
