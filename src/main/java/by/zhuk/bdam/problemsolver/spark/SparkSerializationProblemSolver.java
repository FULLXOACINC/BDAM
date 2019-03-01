package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.SparkJobConfig;
import org.json.JSONObject;

public class SparkSerializationProblemSolver implements JsonProblemSolver {
    @Override
    public JSONObject solve(JobConfig config) {
        JSONObject result = new JSONObject();
        SparkJobConfig sparkJobConfig = (SparkJobConfig) config;
        JSONObject newConfig = new JSONObject();
        if (sparkJobConfig.getSparkParams().containsKey("spark.serializer")) {
            if (sparkJobConfig.getSparkParams().get("spark.serializer").equals("org.apache.spark.serializer.KryoSerializer")) {
                result.put("text", "Try to use custom serializer or .......");
            } else {
                result.put("text", "Try to use KryoSerializer serializer or .......");
                newConfig.put("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
            }
        } else {
            result.put("text", "Try to use KryoSerializer serializer or .......");
            newConfig.put("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        }
        result.put("config", newConfig);
        return result;
    }
}
