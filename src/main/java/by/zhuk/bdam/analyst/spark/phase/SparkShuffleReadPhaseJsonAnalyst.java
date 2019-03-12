package by.zhuk.bdam.analyst.spark.phase;

import org.json.JSONObject;

public class SparkShuffleReadPhaseJsonAnalyst implements PhaseProblemJsonAnalyst {

    public boolean isPhaseHasProblem(JSONObject jsonObject) {
        double shuffleReadTimeMax = jsonObject.getJSONObject("shuffleReadMetrics").getJSONArray("fetchWaitTime").getDouble(2) / 1000;
        double shuffleReadTimeMedian = jsonObject.getJSONObject("shuffleReadMetrics").getJSONArray("fetchWaitTime").getDouble(1) / 1000;

        double executorRunTimeMax = jsonObject.getJSONArray("executorRunTime").getDouble(2) / 1000;
        double executorRunTimeMedian = jsonObject.getJSONArray("executorRunTime").getDouble(1) / 1000;

        return (shuffleReadTimeMax / executorRunTimeMax) > 0.05 || (shuffleReadTimeMedian / executorRunTimeMedian) > 0.05;
    }
}
