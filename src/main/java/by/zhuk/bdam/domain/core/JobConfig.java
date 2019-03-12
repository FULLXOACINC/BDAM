package by.zhuk.bdam.domain.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobConfig {
    private String appPath;
    private String appName;
    private List<String> argsList;
    private boolean isVerbose;

    public JobConfig() {
        argsList = new ArrayList<>();
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

    public Map<String,String> toMapConfig(){
        Map<String,String> map = new HashMap<>();
        map.put("app_name",appName);
        map.put("app_path",appPath);
        map.put("app_args",argsList.toString());
        map.put("verbose", String.valueOf(isVerbose));
        return map;
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
