package by.zhuk.bdam.domain.core;

import by.zhuk.bdam.util.ByteSizeHumanReadableConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Report {
    private String appName;
    private Map<String, String> configs;
    private long executingTime;
    private double dataProcessingSize;
    private List<String> problems;
    private Map<String, String> solutionMap;

    public Report() {
        problems = new ArrayList<>();
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

    public double getDataProcessingSize() {
        return dataProcessingSize;
    }

    public void setDataProcessingSize(double dataProcessingSize) {
        this.dataProcessingSize = dataProcessingSize;
    }

    public List<String> getProblems() {
        return problems;
    }

    public void setProblems(List<String> problems) {
        this.problems = problems;
    }

    public Map<String, String> getSolutionMap() {
        return solutionMap;
    }

    public void setSolutionMap(Map<String, String> solutionMap) {
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
        buffer.append("Data processing size : ").append(ByteSizeHumanReadableConverter.format(dataProcessingSize, 3)).append("\n");
        buffer.append("--------------------").append("\n");
        buffer.append("Config : ").append("\n");
        for (Map.Entry<String, String> entry : configs.entrySet()) {
            buffer.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        buffer.append("--------------------").append("\n");
        buffer.append("Problems : ").append("\n");
        for (String problem : problems) {
            buffer.append(problem).append("\n");
            if(solutionMap.containsKey(problem)){
                buffer.append("\n");
                buffer.append("Solution ").append(" : ").append(solutionMap.get(problem)).append("\n");
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
                ", dataProcessingSize=" + dataProcessingSize +
                ", problems=" + problems +
                ", solutionMap=" + solutionMap +
                '}';
    }
}
