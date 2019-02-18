package by.zhuk.bdam.starter;


import by.zhuk.bdam.configparser.ConfigParser;
import by.zhuk.bdam.configparser.SparkConfigParser;
import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.exception.ParseConfigException;
import by.zhuk.bdam.exception.SparkJobExecuteException;
import by.zhuk.bdam.executor.JobExecutor;
import by.zhuk.bdam.executor.SparkJobExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.spark.launcher.SparkLauncher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Starter {
    private static Logger logger = LogManager.getLogger(Starter.class);
    private static Map<String, ConfigParser> parserMap;
    private static Map<String, JobExecutor> executorMap;

    static {
        parserMap = new HashMap<>();
        executorMap = new HashMap<>();
        parserMap.put("spark", new SparkConfigParser());
        executorMap.put("spark", new SparkJobExecutor());
    }


    public static void main(String[] args) {
        if (args.length != 2) {
            logger.error("Invalid args count: must set up mode and config file");
            return;
        }
        ConfigParser parser = parserMap.get(args[0]);
        JobExecutor executor = executorMap.get(args[0]);
        if (parser == null || executor == null) {
            logger.info("Not found execute mode");
            return;
        }
        try {
            JobConfig config = parser.parse(args[1]);
            System.out.println(executor.executeJob(config));
        } catch (ParseConfigException | SparkJobExecuteException e) {
            logger.error("Error",e);
        }
    }
}

