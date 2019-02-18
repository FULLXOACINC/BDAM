package by.zhuk.bdam.configparser;

import by.zhuk.bdam.domain.DeployMode;
import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.SparkJobConfig;
import by.zhuk.bdam.exception.ParseConfigException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class SparkConfigParser implements ConfigParser {
    @Override
    public JobConfig parse(String confFile) throws ParseConfigException {
        if (confFile == null) {
            throw new ParseConfigException("Config file is null");
        }
        try {
            String text = new String(Files.readAllBytes(Paths.get(confFile)), StandardCharsets.UTF_8);
            JSONObject rootJson = new JSONObject(text);
            SparkJobConfig config = new SparkJobConfig();
            config.setAppName(rootJson.getString("app_name"));
            config.setAppArgString(rootJson.getString("app_args"));
            config.setAppPath(rootJson.getString("app_path"));
            JSONObject sparkJson =rootJson.getJSONObject("spark");
            config.setMainClass(sparkJson.getString("class"));
            config.setMode(DeployMode.valueOf(sparkJson.getString("deploy_mode").toUpperCase()));
            config.setMaster(sparkJson.getString("master"));
            JSONObject sparkConfigJson = sparkJson.getJSONObject("config");
            for (Iterator<String> it = sparkConfigJson.keys(); it.hasNext(); ) {
                String key = it.next();
                config.getSparkParams().put(key,sparkConfigJson.getString(key));
            }

            return config;
        } catch (IOException | IllegalArgumentException e) {
            throw new ParseConfigException("Config file is invalid", e);
        }

    }
}
