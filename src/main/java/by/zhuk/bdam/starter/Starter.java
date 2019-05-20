package by.zhuk.bdam.starter;

import by.zhuk.bdam.analyst.core.JsonAnalyst;
import by.zhuk.bdam.domain.core.AppType;
import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;
import by.zhuk.bdam.domain.core.Report;
import by.zhuk.bdam.exception.*;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Starter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);
    private static final String HELP_FILE = "/help.txt";
    private static final String HELP_PARAMETER = "--help";

    private static void showHelpMessage() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Starter.class.getResourceAsStream(HELP_FILE)))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            LOGGER.error("Error to view help message " + e);
        }
    }

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals(HELP_PARAMETER)) {
                showHelpMessage();
                return;
            }
        }
        if (args.length < 4) {
            LOGGER.error("Invalid args count: must set up app type, config file and new config file name, sender report type and param for sender");
            return;
        }
        String stringAppType = args[1];
        String configFile = args[3];
        String newConfigFile = args[5];
        String senderType = args[7];
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
            String appId = executor.executeJob(config);
            JSONObject metric = dumper.dump(appId, config);
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
        } catch (JobExecuteException e) {
            e.printStackTrace();
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

