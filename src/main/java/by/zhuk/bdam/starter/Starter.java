package by.zhuk.bdam.starter;

import by.zhuk.bdam.analyst.core.JsonAnalyst;
import by.zhuk.bdam.domain.AppType;
import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.exception.JobDumpException;
import by.zhuk.bdam.exception.JobExecuteException;
import by.zhuk.bdam.exception.ParseConfigException;
import by.zhuk.bdam.executor.JobExecutor;
import by.zhuk.bdam.infodumper.AppInfoJsonDumper;
import by.zhuk.bdam.parser.ConfigParser;
import by.zhuk.bdam.problemsolver.core.JsonAppProblemSolver;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);


    public static void main(String[] args) {
        if (args.length != 2) {
            LOGGER.error("Invalid args count: must set up mode and config file");
            return;
        }
        if (AppType.contains(args[0])) {
            LOGGER.error("Not found application type");
            return;
        }
        AppType appType = AppType.valueOf(args[0].toUpperCase());
        ConfigParser parser = appType.getParse();
        JobExecutor executor = appType.getExecutor();
        AppInfoJsonDumper dumper = appType.getDumper();
        JsonAnalyst analyst = appType.getAnalyst();
        JsonAppProblemSolver problemSolver = appType.getProblemSolver();

        try {
            JobConfig config = parser.parse(args[1]);
            String appId = executor.executeJob(config);
            JSONObject metric = dumper.dump(appId, config);
            JSONObject analysis = analyst.analyze(metric);
            System.out.println(problemSolver.solveProblem(analysis, config));
        } catch (ParseConfigException | JobDumpException | JobExecuteException e) {
            LOGGER.error("Error", e);
        }
    }

}

