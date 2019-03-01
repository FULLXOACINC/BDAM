package by.zhuk.bdam.analyst.spark.phase;

import org.json.JSONObject;

public class SparkGettingResultPhaseJsonAnalyst implements PhaseProblemJsonAnalyst {

    public boolean isPhaseHasProblem(JSONObject jsonObject) {
        double gettingResultTimeMax = jsonObject.getJSONArray("gettingResultTime").getDouble(1) / 1000;
        double gettingResultTimeMedian = jsonObject.getJSONArray("gettingResultTime").getDouble(0) / 1000;

        double executorRunTimeMax = jsonObject.getJSONArray("executorRunTime").getDouble(1) / 1000;
        double executorRunTimeMedian = jsonObject.getJSONArray("executorRunTime").getDouble(0) / 1000;

        return (gettingResultTimeMax + gettingResultTimeMedian) / (executorRunTimeMax + executorRunTimeMedian) > 0.05;
    }
}
