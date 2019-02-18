package by.zhuk.bdam.domain;

import java.util.ArrayList;
import java.util.List;

public class JobConfig {
    private String appPath;
    private String appName;
    private List<String> argsList;
    private boolean isVerbose;

    public JobConfig() {
        argsList= new ArrayList<>();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }


    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public List<String> getArgsList() {
        return argsList;
    }

    public void setArgsList(List<String> argsList) {
        this.argsList = argsList;
    }

    public boolean isVerbose() {
        return isVerbose;
    }

    public void setVerbose(boolean verbose) {
        isVerbose = verbose;
    }

    @Override
    public String toString() {
        return "JobConfig{" +
                "appPath='" + appPath + '\'' +
                ", appName='" + appName + '\'' +
                ", argsList=" + argsList +
                ", isVerbose=" + isVerbose +
                '}';
    }
}
