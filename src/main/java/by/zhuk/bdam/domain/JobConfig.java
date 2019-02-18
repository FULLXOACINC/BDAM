package by.zhuk.bdam.domain;

public class JobConfig {
    private String appPath;
    private String appName;
    private String appArgString;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppArgString() {
        return appArgString;
    }

    public void setAppArgString(String appArgString) {
        this.appArgString = appArgString;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    @Override
    public String toString() {
        return "JobConfig{" +
                "appPath='" + appPath + '\'' +
                ", appName='" + appName + '\'' +
                ", appArgString='" + appArgString + '\'' +
                '}';
    }
}
