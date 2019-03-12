package by.zhuk.bdam.analyst.spark.phase;

import org.json.JSONObject;

public class SparkShuffleWritePhaseJsonAnalyst implements PhaseProblemJsonAnalyst {

    public boolean isPhaseHasProblem(JSONObject jsonObject) {
        double shuffleWriteTimeMax = jsonObject.getJSONObject("shuffleWriteMetrics").getJSONArray("writeTime").getDouble(2) / 1000000000;
        double shuffleWriteTimeMedian = jsonObject.getJSONObject("shuffleWriteMetrics").getJSONArray("writeTime").getDouble(1) / 1000000000;

        double executorRunTimeMax = jsonObject.getJSONArray("executorRunTime").getDouble(2) / 1000;
        double executorRunTimeMedian = jsonObject.getJSONArray("executorRunTime").getDouble(1) / 1000;

        return (shuffleWriteTimeMax / executorRunTimeMax) > 0.05 || (shuffleWriteTimeMedian / executorRunTimeMedian) > 0.05;
    }
}
