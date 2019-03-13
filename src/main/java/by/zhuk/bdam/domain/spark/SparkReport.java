package by.zhuk.bdam.domain.spark;

import by.zhuk.bdam.domain.core.Report;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SparkReport extends Report {
    private Map<Long, SparkStageMetric> stageMetricMap;

    public SparkReport() {
        stageMetricMap = new HashMap<>();
    }

    public Map<Long, SparkStageMetric> getStageMetricMap() {
        return stageMetricMap;
    }

    public void setStageMetricMap(Map<Long, SparkStageMetric> stageMetricMap) {
        this.stageMetricMap = stageMetricMap;
    }

    @Override
    public String toReadableString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toReadableString());
        buffer.append("Stage metrics:\n");
        for(Map.Entry<Long, SparkStageMetric> entry : stageMetricMap.entrySet()){
            buffer.append("Stage :").append(entry.getKey()).append("\n");

            String time = String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(entry.getValue().getDuration()),
                    TimeUnit.MILLISECONDS.toSeconds(entry.getValue().getDuration()) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(entry.getValue().getDuration()))
            );
            buffer.append("Duration :").append(time).append("\n");
            buffer.append(entry.getValue().toReadableString()).append("\n");
        }
        return buffer.toString();
    }
}
