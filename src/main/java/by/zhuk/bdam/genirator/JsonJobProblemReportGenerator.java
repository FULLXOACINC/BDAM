package by.zhuk.bdam.genirator;

import by.zhuk.bdam.domain.core.JobConfig;
import by.zhuk.bdam.domain.core.JobProblemSolution;
import org.json.JSONObject;

import java.util.Map;

public interface JsonJobProblemReportGenerator extends ReportGenerator<JSONObject, Map<String, JobProblemSolution>, JobConfig> {

}
