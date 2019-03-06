package by.zhuk.bdam.domain.spark;

import by.zhuk.bdam.domain.core.DeployMode;
import by.zhuk.bdam.domain.core.JobConfig;

import java.util.HashMap;
import java.util.Map;

public class SparkJobConfig extends JobConfig {
    private String master;
    private String mainClass;
    private DeployMode mode;
    private String javaHome;
    private String sparkHome;
    private String historyServerAddress;

    private Map<String, String> sparkParams;

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

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    public String getSparkHome() {
        return sparkHome;
    }

    public void setSparkHome(String sparkHome) {
        this.sparkHome = sparkHome;
    }

    public String getHistoryServerAddress() {
        return historyServerAddress;
    }

    public void setHistoryServerAddress(String historyServerAddress) {
        this.historyServerAddress = historyServerAddress;
    }

    @Override
    public String toString() {
        return "SparkJobConfig{" +
                "master='" + master + '\'' +
                ", mainClass='" + mainClass + '\'' +
                ", mode=" + mode +
                ", javaHome='" + javaHome + '\'' +
                ", sparkHome='" + sparkHome + '\'' +
                ", sparkParams=" + sparkParams +
                '}';
    }
}
