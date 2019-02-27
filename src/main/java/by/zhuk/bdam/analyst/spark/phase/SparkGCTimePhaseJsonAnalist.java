package by.zhuk.bdam.analyst.spark.phase;

import org.json.JSONObject;

public class SparkGCTimePhaseJsonAnalist implements PhaseProblemJsonAnalyst {

    public boolean isPhaseHasProblem(JSONObject jsonObject) {
        double jvmGcTimeMax = jsonObject.getJSONArray("jvmGcTime").getDouble(1) / 1000;
        double jvmGcTimeMedian = jsonObject.getJSONArray("jvmGcTime").getDouble(0) / 1000;

        double executorRunTimeMax = jsonObject.getJSONArray("executorRunTime").getDouble(1) / 1000;
        double executorRunTimeMedian = jsonObject.getJSONArray("executorRunTime").getDouble(0) / 1000;

        return (jvmGcTimeMax + jvmGcTimeMedian) / (executorRunTimeMax + executorRunTimeMedian) > 0.05;
    }
}
