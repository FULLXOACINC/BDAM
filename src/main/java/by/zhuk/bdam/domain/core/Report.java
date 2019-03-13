package by.zhuk.bdam.domain.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Report {
    private String appName;
    private Map<String, String> configs;
    private long executingTime;
    private Map<String, List<String>> solutionMap;

    public Report() {
        configs = new HashMap<>();
        solutionMap = new HashMap<>();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Map<String, String> getConfigs() {
        return configs;
    }

    public void setConfigs(Map<String, String> configs) {
        this.configs = configs;
    }

    public long getExecutingTime() {
        return executingTime;
    }

    public void setExecutingTime(long executingTime) {
        this.executingTime = executingTime;
    }


    public Map<String, List<String>> getSolutionMap() {
        return solutionMap;
    }

    public void setSolutionMap(Map<String, List<String>> solutionMap) {
        this.solutionMap = solutionMap;
    }

    public String toReadableString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Application name : ").append(appName).append("\n");
        String time = String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(executingTime),
                TimeUnit.MILLISECONDS.toSeconds(executingTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(executingTime))
        );
        buffer.append("Execution time : ").append(time).append("\n");
        buffer.append("--------------------").append("\n");
        buffer.append("Config : ").append("\n");
        for (Map.Entry<String, String> entry : configs.entrySet()) {
            buffer.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        buffer.append("--------------------").append("\n");
        buffer.append("Problems : ").append("\n");
        for (Map.Entry<String, List<String>> entry : solutionMap.entrySet()) {
            buffer.append(entry.getKey()).append("\n");
            buffer.append("Solutions :").append("\n");
            for (String solution:entry.getValue()) {
                buffer.append("\t").append(solution).append("\n");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    @Override
    public String toString() {
        return "Report{" +
                "appName='" + appName + '\'' +
                ", configs=" + configs +
                ", executingTime=" + executingTime +
                ", solutionMap=" + solutionMap +
                '}';
    }
}
