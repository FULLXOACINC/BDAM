package by.zhuk.bdam.infodumper;

import by.zhuk.bdam.domain.core.JobConfig;
import org.json.JSONObject;

public interface AppInfoJsonDumper extends AppInfoDumper<JSONObject, JobConfig> {
//    JSONObject dump(String appId, JobConfig config) throws JobDumpException;
}
