package by.zhuk.bdam.analyst;

import org.json.JSONObject;

public class SparkProblemPhaseStageJsonAnalyst implements StageJsonAnalyst {
    @Override
    public JSONObject analyze(JSONObject jsonObject) {
        JSONObject metric = jsonObject.getJSONObject("metric");
        double schedulerDelayMax = metric.getJSONArray("schedulerDelay").getDouble(1) / 1000;
        double executorDeserializeTimeMax = metric.getJSONArray("executorDeserializeTime").getDouble(1) / 1000;
        double shuffleWriteMetricsReadTimeMax = metric.getJSONObject("shuffleReadMetrics").getJSONArray("fetchWaitTime").getDouble(1) / 1000;
        double shuffleWriteMetricsWriteTimeMax = metric.getJSONObject("shuffleWriteMetrics").getJSONArray("writeTime").getDouble(1) / 1000000000;
        double resultSerializationTimeMax = metric.getJSONArray("resultSerializationTime").getDouble(1) / 1000;
        double gettingResultTimeMax = metric.getJSONArray("gettingResultTime").getDouble(1) / 1000;

        double executorRunTimeMax = metric.getJSONArray("executorRunTime").getDouble(1) / 1000;
        double jvmGcTimeMax = metric.getJSONArray("jvmGcTime").getDouble(1) / 1000;

        double schedulerDelayMedian = metric.getJSONArray("schedulerDelay").getDouble(0) / 1000;
        double executorDeserializeTimeMedian = metric.getJSONArray("executorDeserializeTime").getDouble(0) / 1000;
        double shuffleWriteMetricsReadTimeMedian = metric.getJSONObject("shuffleReadMetrics").getJSONArray("fetchWaitTime").getDouble(0) / 1000;
        double shuffleWriteMetricsWriteTimeMedian = metric.getJSONObject("shuffleWriteMetrics").getJSONArray("writeTime").getDouble(0) / 1000000000;
        double resultSerializationTimeMedian = metric.getJSONArray("resultSerializationTime").getDouble(0) / 1000;
        double gettingResultTimeMedian = metric.getJSONArray("gettingResultTime").getDouble(0) / 1000;

        double executorRunTimeMedian = metric.getJSONArray("executorRunTime").getDouble(0) / 1000;
        double jvmGcTimeMedian = metric.getJSONArray("jvmGcTime").getDouble(0) / 1000;


        System.out.println("Max");
        System.out.println(schedulerDelayMax);
        System.out.println(executorDeserializeTimeMax);
        System.out.println(shuffleWriteMetricsReadTimeMax);
        System.out.println(shuffleWriteMetricsWriteTimeMax);
        System.out.println(resultSerializationTimeMax);
        System.out.println(gettingResultTimeMax);
        System.out.println("------");
        System.out.println(executorRunTimeMax);
        System.out.println(jvmGcTimeMax);

        System.out.println("Median");
        System.out.println(schedulerDelayMedian);
        System.out.println(executorDeserializeTimeMedian);
        System.out.println(shuffleWriteMetricsReadTimeMedian);
        System.out.println(shuffleWriteMetricsWriteTimeMedian);
        System.out.println(resultSerializationTimeMedian);
        System.out.println(gettingResultTimeMedian);
        System.out.println("------");
        System.out.println(executorRunTimeMedian);
        System.out.println(jvmGcTimeMedian);

        return jsonObject;
    }
}
