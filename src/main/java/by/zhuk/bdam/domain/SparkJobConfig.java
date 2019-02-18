package by.zhuk.bdam.domain;

import java.util.HashMap;
import java.util.Map;

public class SparkJobConfig extends JobConfig{
    private String master ;
    private String mainClass;
    private DeployMode mode;
    private Map<String,String> sparkParams;

    public SparkJobConfig() {
        sparkParams = new HashMap<>();
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Map<String, String> getSparkParams() {
        return sparkParams;
    }

    public void setSparkParams(Map<String, String> sparkParams) {
        this.sparkParams = sparkParams;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public DeployMode getMode() {
        return mode;
    }

    public void setMode(DeployMode mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "SparkJobConfig{" +
                "master='" + master + '\'' +
                ", mainClass='" + mainClass + '\'' +
                ", mode=" + mode +
                ", sparkParams=" + sparkParams +
                '}';
    }
}