package by.zhuk.bdam.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobProblemSolution {
    private List<String> descriptions;
    private Map<String, String> config;

    public JobProblemSolution() {
        descriptions = new ArrayList<>();
        config = new HashMap<>();
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
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
                "descriptions=" + descriptions +
                ", config=" + config +
                '}';
    }
}
