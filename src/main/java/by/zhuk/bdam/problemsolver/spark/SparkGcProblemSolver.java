package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparkGcProblemSolver implements ProblemSolver {

    @Override
    public List<String> findTextSolutions(JobConfig config) {
        ArrayList<String> result  = new ArrayList<>();
        result.add("Gc solution");
        result.add("Gc solution");
        return result;
    }

    @Override
    public Map<String, String> findConfigSolution(JobConfig config) {
        return new HashMap<>();
    }
}
