package by.zhuk.bdam.analyst.spark.phase;

import org.json.JSONObject;

public class SparkShuffleReadPhaseJsonAnalist implements PhaseProblemJsonAnalyst{

    public boolean isPhaseHasProblem(JSONObject jsonObject) {
        double shuffleReadTimeMax = jsonObject.getJSONObject("shuffleReadMetrics").getJSONArray("fetchWaitTime").getDouble(1) / 1000;
        double shuffleReadTimeMedian = jsonObject.getJSONObject("shuffleReadMetrics").getJSONArray("fetchWaitTime").getDouble(0) / 1000;

        double executorRunTimeMax = jsonObject.getJSONArray("executorRunTime").getDouble(1) / 1000;
        double executorRunTimeMedian = jsonObject.getJSONArray("executorRunTime").getDouble(0) / 1000;

        return (shuffleReadTimeMax + shuffleReadTimeMedian) / (executorRunTimeMax + executorRunTimeMedian) > 0.05;
    }
}
