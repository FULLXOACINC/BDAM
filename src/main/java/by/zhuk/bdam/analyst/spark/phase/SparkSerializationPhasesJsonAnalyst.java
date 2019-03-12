package by.zhuk.bdam.analyst.spark.phase;

import org.json.JSONObject;

public class SparkSerializationPhasesJsonAnalyst implements PhaseProblemJsonAnalyst {

    public boolean isPhaseHasProblem(JSONObject jsonObject) {
        double executorDeserializeTimeMax = jsonObject.getJSONArray("executorDeserializeTime").getDouble(2) / 1000;
        double executorDeserializeTimeMedian = jsonObject.getJSONArray("executorDeserializeTime").getDouble(1) / 1000;

        double resultSerializationTimeMedian = jsonObject.getJSONArray("resultSerializationTime").getDouble(1) / 1000;
        double resultSerializationTimeMax = jsonObject.getJSONArray("resultSerializationTime").getDouble(2) / 1000;

        double executorRunTimeMax = jsonObject.getJSONArray("executorRunTime").getDouble(2) / 1000;
        double executorRunTimeMedian = jsonObject.getJSONArray("executorRunTime").getDouble(1) / 1000;

        boolean isDeserializationProblem = (executorDeserializeTimeMax / executorRunTimeMax) > 0.05 || (executorDeserializeTimeMedian / executorRunTimeMedian) > 0.05;
        boolean isSerializationProblem = (resultSerializationTimeMax / executorRunTimeMax) > 0.05 || (resultSerializationTimeMedian / executorRunTimeMedian) > 0.05;
        return isDeserializationProblem || isSerializationProblem;
    }
}
