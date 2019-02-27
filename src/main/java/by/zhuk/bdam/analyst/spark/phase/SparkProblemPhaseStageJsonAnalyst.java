package by.zhuk.bdam.analyst.spark.phase;

import by.zhuk.bdam.analyst.core.JsonAnalyst;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SparkProblemPhaseStageJsonAnalyst implements JsonAnalyst {
    private static final Map<String, PhaseProblemJsonAnalyst> phaseAnalystList;

    static {
        phaseAnalystList = new HashMap<>();
        phaseAnalystList.put("jvmGc", new SparkGCTimePhaseJsonAnalist());
        phaseAnalystList.put("gettingResult", new SparkGettingResultPhaseJsonAnalist());
        phaseAnalystList.put("schedulerDelay", new SparkSchedulerDelayPhaseJsonAnalist());
        phaseAnalystList.put("serialization", new SparkSerializationPhasesJsonAnalist());
        phaseAnalystList.put("shuffleRead", new SparkShuffleReadPhaseJsonAnalist());
        phaseAnalystList.put("shuffleWrite", new SparkShuffleWritePhaseJsonAnalist());
    }
    @Override
    public JSONObject analyze(JSONObject jsonObject) {
        JSONObject result = new JSONObject(jsonObject.toString());
        JSONObject metric = jsonObject.getJSONObject("metric");
        JSONArray problem = new JSONArray();
        for (Map.Entry<String, PhaseProblemJsonAnalyst> entry: phaseAnalystList.entrySet()) {
            if(entry.getValue().isPhaseHasProblem(metric)){
                problem.put(entry.getKey());
            }
        }

        result.put("problems",problem);


        return result;
    }
}
