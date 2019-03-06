package by.zhuk.bdam.serializer;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.spark.SparkJobConfig;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class SparkJobJsonSerializer implements JobConfigJsonSerializer {
    @Override
    public JSONObject serialize(JobConfig jobConfig) {
        SparkJobConfig sparkJobConfig = (SparkJobConfig) jobConfig;
        JSONObject json = new JSONObject();
        json.put("app_name", sparkJobConfig.getAppName());
        json.put("app_path", sparkJobConfig.getAppPath());
        json.put("verbose", sparkJobConfig.isVerbose());
        json.put("app_args", new JSONArray(sparkJobConfig.getArgsList()));
        JSONObject sparkJson = new JSONObject();
        sparkJson.put("history_server_address",sparkJobConfig.getHistoryServerAddress());
        sparkJson.put("java_home",sparkJobConfig.getJavaHome());
        sparkJson.put("spark_home",sparkJobConfig.getSparkHome());
        sparkJson.put("master",sparkJobConfig.getMaster());
        sparkJson.put("class",sparkJobConfig.getMainClass());
        sparkJson.put("deploy_mode",sparkJobConfig.getMode().name().toLowerCase());

        JSONObject config = new JSONObject();
        for(Map.Entry<String,String> entry : sparkJobConfig.getSparkParams().entrySet()){
            config.put(entry.getKey(),entry.getValue());
        }
        sparkJson.put("config",config);
        json.put("spark", sparkJson);

        return json;
    }
}
