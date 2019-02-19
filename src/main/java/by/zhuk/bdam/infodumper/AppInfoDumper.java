package by.zhuk.bdam.infodumper;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.exception.JobDumpException;
import org.json.JSONObject;

public interface AppInfoDumper {
    JSONObject dump(String appId, JobConfig config) throws JobDumpException;
}
