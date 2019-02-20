package by.zhuk.bdam.starter;

import by.zhuk.bdam.analyst.AppJsonAnalyst;
import by.zhuk.bdam.analyst.SparkAppAppJsonAnalyst;
import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.exception.JobDumpException;
import by.zhuk.bdam.exception.JobExecuteException;
import by.zhuk.bdam.exception.ParseConfigException;
import by.zhuk.bdam.executor.JobExecutor;
import by.zhuk.bdam.executor.SparkJobExecutor;
import by.zhuk.bdam.infodumper.AppInfoJsonDumper;
import by.zhuk.bdam.infodumper.SparkAppInfoJsonDumper;
import by.zhuk.bdam.parser.ConfigParser;
import by.zhuk.bdam.parser.SparkConfigParser;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Starter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);
    private static Map<String, ConfigParser> parserMap;
    private static Map<String, JobExecutor> executorMap;
    private static Map<String, AppInfoJsonDumper> dumperMap;
    private static Map<String, AppJsonAnalyst> analystMap;

    static {
        parserMap = new HashMap<>();
        executorMap = new HashMap<>();
        dumperMap = new HashMap<>();
        analystMap = new HashMap<>();
        parserMap.put("spark", new SparkConfigParser());
        executorMap.put("spark", new SparkJobExecutor());
        dumperMap.put("spark", new SparkAppInfoJsonDumper());
        analystMap.put("spark", new SparkAppAppJsonAnalyst());
    }


    public static void main(String[] args) {
        if (args.length != 2) {
            LOGGER.error("Invalid args count: must set up mode and config file");
            return;
        }
        ConfigParser parser = parserMap.get(args[0]);
        JobExecutor executor = executorMap.get(args[0]);
        AppInfoJsonDumper dumper = dumperMap.get(args[0]);
        AppJsonAnalyst analyst = analystMap.get(args[0]);
        if (parser == null || executor == null) {
            LOGGER.info("Not found execute mode");
            return;
        }
        try {
            JobConfig config = parser.parse(args[1]);
            String appId = executor.executeJob(config);
            JSONObject metric = dumper.dump(appId, config);
            JSONObject analysis =analyst.analyze(metric);
        } catch (ParseConfigException | JobDumpException | JobExecuteException e) {
            LOGGER.error("Error", e);
        }
    }
}

