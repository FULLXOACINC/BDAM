package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;
import by.zhuk.bdam.problemsolver.core.JsonAppProblemSolver;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SparkJsonAppProblemSolver implements JsonAppProblemSolver {
    private static Map<String, ProblemSolver> solutionMap;

    static {
        solutionMap = new HashMap<>();
        solutionMap.put("jvmGc", new SparkGcProblemSolver());
        solutionMap.put("gettingResult", new SparkGettingResultProblemSolver());
        solutionMap.put("schedulerDelay", new SparkSchedulerDelayProblemSolver());
        solutionMap.put("serialization", new SparkSerializationProblemSolver());
        solutionMap.put("shuffleRead", new SparkShuffleReadProblemSolver());
        solutionMap.put("shuffleWrite", new SparkShuffleWriteProblemSolver());
    }

    @Override
    public Map<String,JobProblemSolution> solveProblems(JSONObject jsonObject, JobConfig config) {
        Map<String,JobProblemSolution> solutionsMap = new HashMap<>();

        Set<String> problems = new HashSet<>();
        JSONArray array = jsonObject.getJSONArray("problems");
        for (Object stageObj : array) {
            JSONObject stage = (JSONObject) stageObj;
            for (Object problemObj : stage.getJSONArray("stageProblems")) {
                String problem = (String) problemObj;
                problems.add(problem);
            }
        }
        for (String problem : problems) {
            if (solutionMap.containsKey(problem)) {
                ProblemSolver solver = solutionMap.get(problem);
                JobProblemSolution solution = new JobProblemSolution();

                solution.setDescription(solver.findTextSolution(config));
                solution.getConfig().putAll(solver.findConfigSolution(config));
                solutionsMap.put(problem,solution);
            }

        }
        return solutionsMap;
    }
}
