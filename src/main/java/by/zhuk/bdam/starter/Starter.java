package by.zhuk.bdam.starter;

import by.zhuk.bdam.analyst.core.JsonAnalyst;
import by.zhuk.bdam.domain.AppType;
import by.zhuk.bdam.domain.JobConfig;
import by.zhuk.bdam.domain.JobProblemSolution;
import by.zhuk.bdam.exception.JobDumpException;
import by.zhuk.bdam.exception.JobExecuteException;
import by.zhuk.bdam.exception.ParseConfigException;
import by.zhuk.bdam.exception.WriteFileException;
import by.zhuk.bdam.executor.JobExecutor;
import by.zhuk.bdam.infodumper.AppInfoJsonDumper;
import by.zhuk.bdam.parser.ConfigParser;
import by.zhuk.bdam.problemsolver.core.JsonAppProblemSolver;
import by.zhuk.bdam.reconfiger.JobReconfiguer;
import by.zhuk.bdam.serializer.JobConfigJsonSerializer;
import by.zhuk.bdam.writer.JSONObjectFileWriter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);


    public static void main(String[] args) {
        if (args.length != 3) {
            LOGGER.error("Invalid args count: must set up mode, config file and new config file name");
            return;
        }
        String type = args[0];
        String configFile = args[1];
        String newConfigFile = args[2];
        if (AppType.contains(type)) {
            LOGGER.error("Not found application type");
            return;
        }

        AppType appType = AppType.valueOf(type.toUpperCase());
        ConfigParser parser = appType.getParse();
        JobExecutor executor = appType.getExecutor();
        JobReconfiguer reconfiguer = appType.getReconfiguer();
        AppInfoJsonDumper dumper = appType.getDumper();
        JsonAnalyst analyst = appType.getAnalyst();
        JsonAppProblemSolver problemSolver = appType.getProblemSolver();
        JobConfigJsonSerializer jobConfigJsonSerializer = appType.getJobConfigJsonSerializer();
        JSONObjectFileWriter writer = new JSONObjectFileWriter();
        try {
            JobConfig config = parser.parse(configFile);
            String appId = executor.executeJob(config);
            JSONObject metric = dumper.dump(appId, config);
            JSONObject analysis = analyst.analyze(metric);
            JobProblemSolution solution = problemSolver.solveProblem(analysis, config);
            if (!solution.getConfig().isEmpty()) {
                reconfiguer.reconfigure(solution, config);
                JSONObject json = jobConfigJsonSerializer.serialize(config);
                writer.write(json, newConfigFile);
            }

        } catch (ParseConfigException | JobDumpException | WriteFileException | JobExecuteException e) {
            LOGGER.error("Error", e);
        }
    }

}

