package by.zhuk.bdam.analyst.spark.phase;

import org.json.JSONObject;

public class SparkSchedulerDelayPhaseJsonAnalyst implements PhaseProblemJsonAnalyst {

    public boolean isPhaseHasProblem(JSONObject jsonObject) {
        double schedulerDelayMax = jsonObject.getJSONArray("schedulerDelay").getDouble(2) / 1000;
        double schedulerDelayMedian = jsonObject.getJSONArray("schedulerDelay").getDouble(1) / 1000;

        double executorRunTimeMax = jsonObject.getJSONArray("executorRunTime").getDouble(2) / 1000;
        double executorRunTimeMedian = jsonObject.getJSONArray("executorRunTime").getDouble(1) / 1000;

        return (schedulerDelayMax / executorRunTimeMax) > 0.05 || (schedulerDelayMedian / executorRunTimeMedian) > 0.05;
    }
}
