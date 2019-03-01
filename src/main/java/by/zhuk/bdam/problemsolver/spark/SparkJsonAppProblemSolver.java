package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.problemsolver.core.JsonAppProblemSolver;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SparkJsonAppProblemSolver implements JsonAppProblemSolver {
    private static Map<String, JsonProblemSolver> solutionMap;

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
    public JSONObject solveProblem(JSONObject jsonObject, JobConfig config) {
        JSONObject result = new JSONObject();
        JSONArray solutions = new JSONArray();
        Set<String> problems = new HashSet<>();
        JSONArray array = jsonObject.getJSONArray("problems");
        for (Object stageObj : array) {
            JSONObject stage = (JSONObject) stageObj;
            for (Object problemObj : stage.getJSONArray("problems")) {
                String problem = (String) problemObj;
                problems.add(problem);
            }
        }
        for (String problem : problems) {
            if (solutionMap.containsKey(problem)) {
                solutions.put(solutionMap.get(problem).solve(config));
            }

        }
        result.put("solutions", solutions);
        return result;
    }
}
