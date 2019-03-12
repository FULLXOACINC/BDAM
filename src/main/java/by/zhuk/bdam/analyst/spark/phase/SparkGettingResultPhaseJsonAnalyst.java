package by.zhuk.bdam.analyst.spark.phase;

import org.json.JSONObject;

public class SparkGettingResultPhaseJsonAnalyst implements PhaseProblemJsonAnalyst {

    public boolean isPhaseHasProblem(JSONObject jsonObject) {
        double gettingResultTimeMax = jsonObject.getJSONArray("gettingResultTime").getDouble(2) / 1000;
        double gettingResultTimeMedian = jsonObject.getJSONArray("gettingResultTime").getDouble(1) / 1000;

        double executorRunTimeMax = jsonObject.getJSONArray("executorRunTime").getDouble(2) / 1000;
        double executorRunTimeMedian = jsonObject.getJSONArray("executorRunTime").getDouble(1) / 1000;

        return (gettingResultTimeMax / executorRunTimeMax) > 0.05 || (gettingResultTimeMedian / executorRunTimeMedian) > 0.05;
    }
}
