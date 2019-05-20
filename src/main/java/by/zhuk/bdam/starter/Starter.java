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
import javafx.beans.binding.BooleanBinding;
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

    public static void main(String[] args) throws CreateSenderException {
        for (String arg : args) {
            if (arg.equals(HELP_PARAMETER)) {
                showHelpMessage();
                return;
            }
        }
        Map<String,String> params=new ParametersParser().parseParameters(args);
        for (Map.Entry<String,String> entry: params.entrySet()) {
            if(entry.getValue() == null){
                LOGGER.error("Invalid args count: need set up "+ entry.getKey());
                System.exit(-1);
            }
        }
        String stringAppType = params.get("--app_type");
        String configFile = params.get("--config_file");
        String newConfigFile = params.get("--new_config_file");
        String senderType = params.get("--sender_type");
        String appId = params.get("--is_run_app");
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
        try {
            ReportSender sender = appType.getReportSenderFactory().createReportSenderByAppArgs(ReportSenderFactory.SenderType.valueOf(senderType.split(" ")[0].toUpperCase()),params.get("--sender_type"));
            JobConfig config = parser.parse(configFile);
            if(Boolean.valueOf(appId)){
                appId = executor.executeJob(config);
            }
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
        } catch (ParseConfigException | JobDumpException | WriteFileException | ReportSendException | JobExecuteException e) {
            LOGGER.error("Error", e);
            System.exit(-1);
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

