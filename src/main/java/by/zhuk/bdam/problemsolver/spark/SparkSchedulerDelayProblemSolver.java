package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.JobConfig;
import org.json.JSONObject;

public class SparkSchedulerDelayProblemSolver implements JsonProblemSolver {
    @Override
    public JSONObject solve(JobConfig config) {
        JSONObject result = new JSONObject();
        result.put("text", "schedulerDelay solution");
        JSONObject newConfig = new JSONObject();
        result.put("config", newConfig);
        return result;
    }
}
