package by.zhuk.bdam.genirator;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;
import by.zhuk.bdam.domain.core.Report;
import by.zhuk.bdam.domain.spark.SparkReport;
import by.zhuk.bdam.domain.spark.SparkStageMetric;
import org.json.JSONObject;

import java.util.Map;

public class SparkJsonJobProblemReportGenerator implements JsonJobProblemReportGenerator {

    @Override
    public Report generateReport(JSONObject metric, Map<String, JobProblemSolution> solution, JobConfig config) {
        SparkReport report = new SparkReport();
        report.setExecutingTime(metric.getLong("duration"));
        report.setAppName(config.getAppName());

        for (Map.Entry<String, JobProblemSolution> entry : solution.entrySet()) {
            report.getSolutionMap().put(entry.getKey(), entry.getValue().getDescription());
        }
        report.setConfigs(config.toMapConfig());

        for (Object stages : metric.getJSONArray("stages")) {
            JSONObject stageMetric = ((JSONObject) stages).getJSONObject("metric");
            Long id = ((JSONObject) stages).getLong("stageId");
            SparkStageMetric sparkStageMetric = new SparkStageMetric();

            for (int index =0;index<3;index++){
                sparkStageMetric.getDiskBytesSpilled().add(String.valueOf(stageMetric.getJSONArray("diskBytesSpilled").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getExecutorDeserializeTime().add(String.valueOf(stageMetric.getJSONArray("executorDeserializeTime").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getExecutorDeserializeCpuTime().add(String.valueOf(stageMetric.getJSONArray("executorDeserializeCpuTime").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getExecutorRunTime().add(String.valueOf(stageMetric.getJSONArray("executorRunTime").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getExecutorCpuTime().add(String.valueOf(stageMetric.getJSONArray("executorCpuTime").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getResultSize().add(String.valueOf(stageMetric.getJSONArray("resultSize").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getJvmGcTime().add(String.valueOf(stageMetric.getJSONArray("jvmGcTime").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getResultSerializationTime().add(String.valueOf(stageMetric.getJSONArray("resultSerializationTime").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getGettingResultTime().add(String.valueOf(stageMetric.getJSONArray("gettingResultTime").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getSchedulerDelay().add(String.valueOf(stageMetric.getJSONArray("schedulerDelay").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getPeakExecutionMemory().add(String.valueOf(stageMetric.getJSONArray("peakExecutionMemory").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getMemoryBytesSpilled().add(String.valueOf(stageMetric.getJSONArray("memoryBytesSpilled").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getInputMetricsBytesRead().add(String.valueOf(stageMetric.getJSONObject("inputMetrics").getJSONArray("bytesRead").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getInputMetricsRecordsRead().add(String.valueOf(stageMetric.getJSONObject("inputMetrics").getJSONArray("recordsRead").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getOutputMetricsBytesWritten().add(String.valueOf(stageMetric.getJSONObject("outputMetrics").getJSONArray("bytesWritten").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getOutputMetricsRecordsWritten().add(String.valueOf(stageMetric.getJSONObject("outputMetrics").getJSONArray("recordsWritten").getLong(index)));
            }

            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleReadMetricsReadBytes().add(String.valueOf(stageMetric.getJSONObject("shuffleReadMetrics").getJSONArray("readBytes").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleReadMetricsReadRecords().add(String.valueOf(stageMetric.getJSONObject("shuffleReadMetrics").getJSONArray("readRecords").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleReadMetricsRemoteBlocksFetched().add(String.valueOf(stageMetric.getJSONObject("shuffleReadMetrics").getJSONArray("remoteBlocksFetched").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleReadMetricsLocalBlocksFetched().add(String.valueOf(stageMetric.getJSONObject("shuffleReadMetrics").getJSONArray("localBlocksFetched").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleReadMetricsFetchWaitTime().add(String.valueOf(stageMetric.getJSONObject("shuffleReadMetrics").getJSONArray("fetchWaitTime").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleReadMetricsRemoteBytesReadToDisk().add(String.valueOf(stageMetric.getJSONObject("shuffleReadMetrics").getJSONArray("remoteBytesReadToDisk").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleReadMetricsTotalBlocksFetched().add(String.valueOf(stageMetric.getJSONObject("shuffleReadMetrics").getJSONArray("totalBlocksFetched").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleReadMetricsRemoteBytesRead().add(String.valueOf(stageMetric.getJSONObject("shuffleReadMetrics").getJSONArray("remoteBytesRead").getLong(index)));
            }

            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleWriteMetricsWriteBytes().add(String.valueOf(stageMetric.getJSONObject("shuffleWriteMetrics").getJSONArray("writeBytes").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleWriteMetricsWriteRecords().add(String.valueOf(stageMetric.getJSONObject("shuffleWriteMetrics").getJSONArray("writeRecords").getLong(index)));
            }
            for (int index =0;index<3;index++){
                sparkStageMetric.getShuffleWriteMetricsWriteTime().add(String.valueOf(stageMetric.getJSONObject("shuffleWriteMetrics").getJSONArray("writeTime").getLong(index)));
            }
            sparkStageMetric.setDuration(((JSONObject) stages).getDouble("duration"));
            report.getStageMetricMap().put(id,sparkStageMetric);
        }
        return report;
    }
}
