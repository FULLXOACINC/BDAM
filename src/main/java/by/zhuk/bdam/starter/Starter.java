package by.zhuk.bdam.starter;

import by.zhuk.bdam.analyst.core.JsonAnalyst;
import by.zhuk.bdam.domain.core.AppType;
import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;
import by.zhuk.bdam.domain.core.Report;
import by.zhuk.bdam.exception.JobDumpException;
import by.zhuk.bdam.exception.ParseConfigException;
import by.zhuk.bdam.exception.ReportSendException;
import by.zhuk.bdam.exception.WriteFileException;
import by.zhuk.bdam.executor.JobExecutor;
import by.zhuk.bdam.genirator.JsonJobProblemReportGenerator;
import by.zhuk.bdam.infodumper.AppInfoJsonDumper;
import by.zhuk.bdam.parser.ConfigParser;
import by.zhuk.bdam.problemsolver.core.JsonAppProblemSolver;
import by.zhuk.bdam.reconfiger.JobReconfiguer;
import by.zhuk.bdam.sender.core.ConsoleReportSender;
import by.zhuk.bdam.sender.core.ReportSender;
import by.zhuk.bdam.sender.core.ReportSenderFactory;
import by.zhuk.bdam.sender.spark.SparkHtmlReportSender;
import by.zhuk.bdam.serializer.JobConfigJsonSerializer;
import by.zhuk.bdam.writer.JSONObjectFileWriter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Starter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);


    public static void main(String[] args) {
        if (args.length < 4) {
            LOGGER.error("Invalid args count: must set up mode, config file and new config file name, sender report type and param for sender");
            return;
        }
        String stringAppType = args[0];
        String configFile = args[1];
        String newConfigFile = args[2];
        String senderType = args[3];
        if (AppType.contains(stringAppType)) {
            LOGGER.error("Not found application type");
            return;
        }
        if (AppType.contains(stringAppType)) {
            LOGGER.error("Not found sender type");
            return;
        }

        AppType appType = AppType.valueOf(stringAppType.toUpperCase());
        ConfigParser parser = appType.getParse();
        JobExecutor executor = appType.getExecutor();
        JobReconfiguer reconfiguer = appType.getReconfiguer();
        AppInfoJsonDumper dumper = appType.getDumper();
        JsonAnalyst analyst = appType.getAnalyst();
        JsonAppProblemSolver problemSolver = appType.getProblemSolver();
        JobConfigJsonSerializer jobConfigJsonSerializer = appType.getJobConfigJsonSerializer();
        JSONObjectFileWriter writer = new JSONObjectFileWriter();
        JsonJobProblemReportGenerator generator = appType.getJsonJobProblemReportGenerator();
        ReportSender sender = appType.getReportSenderFactory().createReportSenderByAppArgs(ReportSenderFactory.SenderType.valueOf(senderType.toUpperCase()),args);
        try {
            JobConfig config = parser.parse(configFile);
//            String appId = executor.executeJob(config);
            JSONObject metric = dumper.dump("local-1551800625858", config);
            JSONObject analysis = analyst.analyze(metric);
            Map<String, JobProblemSolution> solutionMap = problemSolver.solveProblems(analysis, config);

            Report report = generator.generateReport(metric, solutionMap, config);

            if (isNeedToReconfig(solutionMap)) {
                reconfiguer.reconfigure(solutionMap, config);
                JSONObject json = jobConfigJsonSerializer.serialize(config);
                writer.write(json, newConfigFile);
            }
            sender.sendReport(report);
        } catch (ParseConfigException | JobDumpException | WriteFileException | ReportSendException e) {
            LOGGER.error("Error", e);
        }
    }

    private static boolean isNeedToReconfig(Map<String, JobProblemSolution> solutionMap) {
        for (Map.Entry<String, JobProblemSolution> entry : solutionMap.entrySet()) {
            JobProblemSolution solution = entry.getValue();
            if (!solution.getConfig().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}

