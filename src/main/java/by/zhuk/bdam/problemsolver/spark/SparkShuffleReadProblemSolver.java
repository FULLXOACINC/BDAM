package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.JobConfig;
import org.json.JSONObject;

public class SparkShuffleReadProblemSolver implements JsonProblemSolver {
    @Override
    public JSONObject solve(JobConfig config) {
        JSONObject result = new JSONObject();
        result.put("text", "shuffle read solution");
        JSONObject newConfig = new JSONObject();
        result.put("config", newConfig);
        return result;
    }
}
