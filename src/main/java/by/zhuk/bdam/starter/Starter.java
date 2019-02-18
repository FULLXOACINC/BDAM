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

import java.util.HashMap;
import java.util.Map;

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
            executor.executeJob(config);
        } catch (ParseConfigException | SparkJobExecuteException e) {
            logger.error("Error",e);
        }



//        String cmd = "hdfs dfs -ls /";
//        Runtime run = Runtime.getRuntime();
//        Process pr = run.exec(cmd);
//        pr.waitFor();
//        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//        String line = "";
//        while ((line=buf.readLine())!=null) {
//            System.out.println(line);
//        }

    }
}

