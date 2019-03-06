package by.zhuk.bdam.problemsolver.spark;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.spark.SparkJobConfig;

import java.util.HashMap;
import java.util.Map;

public class SparkSerializationProblemSolver implements ProblemSolver {

    @Override
    public String findTextSolution(JobConfig config) {
        SparkJobConfig sparkJobConfig = (SparkJobConfig) config;
        if (sparkJobConfig.getSparkParams().containsKey("spark.serializer")) {
            if (sparkJobConfig.getSparkParams().get("spark.serializer").equals("org.apache.spark.serializer.KryoSerializer")) {
                return "Try to use custom serializer or .......";
            } else {
                return "Try to use KryoSerializer serializer or .......";
            }
        } else {
            return "Try to use KryoSerializer serializer or .......";
        }
    }

    @Override
    public Map<String, String> findConfigSolution(JobConfig config) {
        Map<String, String> result = new HashMap<>();
        SparkJobConfig sparkJobConfig = (SparkJobConfig) config;
        if (!sparkJobConfig.getSparkParams().containsKey("spark.serializer")) {
            result.put("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        }
        return result;
    }
}
