package by.zhuk.bdam.starter;

import by.zhuk.bdam.analyst.core.JsonAnalyst;
import by.zhuk.bdam.domain.core.AppType;
import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;
import by.zhuk.bdam.domain.core.Report;
import by.zhuk.bdam.exception.JobDumpException;
import by.zhuk.bdam.exception.ParseConfigException;
import by.zhuk.bdam.exception.WriteFileException;
import by.zhuk.bdam.executor.JobExecutor;
import by.zhuk.bdam.genirator.JsonJobProblemReportGenerator;
import by.zhuk.bdam.infodumper.AppInfoJsonDumper;
import by.zhuk.bdam.parser.ConfigParser;
import by.zhuk.bdam.problemsolver.core.JsonAppProblemSolver;
import by.zhuk.bdam.reconfiger.JobReconfiguer;
import by.zhuk.bdam.serializer.JobConfigJsonSerializer;
import by.zhuk.bdam.writer.JSONObjectFileWriter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

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
        JsonJobProblemReportGenerator genirator = appType.getJsonJobProblemReportGenirator();
        try {
            JobConfig config = parser.parse(configFile);
//            String appId = executor.executeJob(config);
            JSONObject metric = dumper.dump("local-1551800625858", config);
            JSONObject analysis = analyst.analyze(metric);
            Map<String, JobProblemSolution> solutionMap = problemSolver.solveProblems(analysis, config);

            boolean isNeedToReconfig = false;
            for (Map.Entry<String, JobProblemSolution> entry : solutionMap.entrySet()) {
                JobProblemSolution solution = entry.getValue();

                if (!solution.getConfig().isEmpty()) {
                    isNeedToReconfig = true;
                    break;
                }
            }

            if (isNeedToReconfig) {
                reconfiguer.reconfigure(solutionMap, config);
                JSONObject json = jobConfigJsonSerializer.serialize(config);
                writer.write(json, newConfigFile);
            }
            Report report = genirator.generateReport(metric, solutionMap, config);
            System.out.println(report.toReadableString());
        } catch (ParseConfigException | JobDumpException | WriteFileException e) {
            LOGGER.error("Error", e);
        }
    }

}

