package by.zhuk.bdam.domain;

import by.zhuk.bdam.analyst.core.JsonAnalyst;
import by.zhuk.bdam.analyst.spark.app.SparkAppJsonAnalyst;
import by.zhuk.bdam.executor.JobExecutor;
import by.zhuk.bdam.executor.SparkJobExecutor;
import by.zhuk.bdam.infodumper.AppInfoJsonDumper;
import by.zhuk.bdam.infodumper.SparkAppInfoJsonDumper;
import by.zhuk.bdam.parser.ConfigParser;
import by.zhuk.bdam.parser.SparkConfigParser;
import by.zhuk.bdam.problemsolver.core.JsonAppProblemSolver;
import by.zhuk.bdam.problemsolver.spark.SparkJsonAppProblemSolver;
import by.zhuk.bdam.reconfiger.JobReconfiguer;
import by.zhuk.bdam.reconfiger.SparkJobReconfiguer;
import by.zhuk.bdam.serializer.JobConfigJsonSerializer;
import by.zhuk.bdam.serializer.SparkJobJsonSerializer;

public enum AppType {
    SPARK(new SparkConfigParser(), new SparkJobExecutor(), new SparkAppInfoJsonDumper(), new SparkAppJsonAnalyst(), new SparkJsonAppProblemSolver(), new SparkJobReconfiguer(),new SparkJobJsonSerializer());

    private ConfigParser parse;
    private JobExecutor executor;
    private AppInfoJsonDumper dumper;
    private JsonAnalyst analyst;
    private JsonAppProblemSolver problemSolver;
    private JobReconfiguer reconfiguer;
    private JobConfigJsonSerializer jobConfigJsonSerializer;

    public static boolean contains(String test) {

        for (AppType type : AppType.values()) {
            if (type.name().equals(test)) {
                return true;
            }
        }

        return false;
    }

    AppType(ConfigParser parse, JobExecutor executor, AppInfoJsonDumper dumper, JsonAnalyst analyst, JsonAppProblemSolver problemSolver, JobReconfiguer reconfiguer, JobConfigJsonSerializer jobConfigJsonSerializer) {
        this.parse = parse;
        this.executor = executor;
        this.dumper = dumper;
        this.analyst = analyst;
        this.problemSolver = problemSolver;
        this.reconfiguer = reconfiguer;
        this.jobConfigJsonSerializer = jobConfigJsonSerializer;
    }

    public ConfigParser getParse() {
        return parse;
    }

    public JobExecutor getExecutor() {
        return executor;
    }

    public AppInfoJsonDumper getDumper() {
        return dumper;
    }

    public JsonAnalyst getAnalyst() {
        return analyst;
    }

    public JsonAppProblemSolver getProblemSolver() {
        return problemSolver;
    }

    public JobReconfiguer getReconfiguer() {
        return reconfiguer;
    }

    public JobConfigJsonSerializer getJobConfigJsonSerializer() {
        return jobConfigJsonSerializer;
    }
}
