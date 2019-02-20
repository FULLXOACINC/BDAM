package by.zhuk.bdam.infodumper;

import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.SparkJobConfig;
import by.zhuk.bdam.exception.JobDumpException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;

public class SparkAppInfoJsonDumper implements AppInfoJsonDumper {
    @Override
    public JSONObject dump(String appId, JobConfig config) throws JobDumpException {
        if (!(config instanceof SparkJobConfig)) {
            throw new JobDumpException("Config is not instance of by.zhuk.bdam.domain.SparkJobConfig");
        }
        HttpClient client = new HttpClient();
        GetMethod methodMainApp = new GetMethod("http://10.6.87.200:18081/api/v1/applications/" + appId);
        GetMethod methodStages = new GetMethod("http://10.6.87.200:18081/api/v1/applications/" + appId + "/stages");
        JSONObject result = new JSONObject();
        try{
            JSONObject appInfo;
            boolean isAppCompleted;
            do{
                client.executeMethod(methodMainApp);
                appInfo = new JSONObject(new JSONTokener(new InputStreamReader(methodMainApp.getResponseBodyAsStream())));
                Long duration = appInfo.getJSONArray("attempts").getJSONObject(0).getLong("duration");
                result.put("duration", duration);
                isAppCompleted=appInfo.getJSONArray("attempts").getJSONObject(0).getBoolean("completed");
            }while(!isAppCompleted);

            client.executeMethod(methodStages);
            JSONArray stages = new JSONArray(new JSONTokener(new InputStreamReader(methodStages.getResponseBodyAsStream())));
            JSONArray stagesMetric = new JSONArray();

            for (Object stageObject : stages) {
                JSONObject stage = (JSONObject) stageObject;
                GetMethod methodMetric = new GetMethod("http://10.6.87.200:18081/api/v1/applications/"
                        + appId + "/stages/" + stage.getInt("stageId") + "/" + stage.getInt("attemptId") + "/taskSummary?quantiles=0.5,1");
                client.executeMethod(methodMetric);
                JSONObject metric = new JSONObject(new JSONTokener(new InputStreamReader(methodMetric.getResponseBodyAsStream())));

                String submissionTime = stage.getString("submissionTime").replace("GMT", "");
                String completionTime = stage.getString("completionTime").replace("GMT", "");

                Duration dur = Duration.between(LocalDateTime.parse(submissionTime), LocalDateTime.parse(completionTime));
                JSONObject object = new JSONObject();
                object.put("duration", dur.toMillis());
                object.put("stageId", stage.getInt("stageId"));
                object.put("attemptId", stage.getInt("attemptId"));
                object.put("metric", metric);
                stagesMetric.put(object);
            }
            result.put("stages", stagesMetric);
        } catch (IOException e) {
            throw new JobDumpException(e);
        }
        return result;
    }

}
