package by.zhuk.bdam.domain;

import java.util.Map;

public class Report {
    private String appName;
    private Map<String, String> configs;
    private double executingTime;
    private double dataProcessingSize;

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

    public double getExecutingTime() {
        return executingTime;
    }

    public void setExecutingTime(double executingTime) {
        this.executingTime = executingTime;
    }

    public double getDataProcessingSize() {
        return dataProcessingSize;
    }

    public void setDataProcessingSize(double dataProcessingSize) {
        this.dataProcessingSize = dataProcessingSize;
    }
}
