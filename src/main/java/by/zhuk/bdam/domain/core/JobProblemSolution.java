package by.zhuk.bdam.domain.core;

import java.util.HashMap;
import java.util.Map;

public class JobProblemSolution {
    private String description;
    private Map<String, String> config;

    public JobProblemSolution() {
        config = new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "JobProblemSolution{" +
                "description=" + description +
                ", config=" + config +
                '}';
    }
}
