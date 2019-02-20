package by.zhuk.bdam.analyst;

import org.json.JSONObject;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SparkAppAppJsonAnalyst implements AppJsonAnalyst {
    private static final double ALPHA =0.95;

    @Override
    public JSONObject analyze(JSONObject json) {
        SparkProblemPhaseStageJsonAnalyst analyst = new SparkProblemPhaseStageJsonAnalyst();
        JSONObject result = new JSONObject(json.toString());
        TreeMap<Integer, JSONObject> stages = new TreeMap<>(Collections.reverseOrder());

        for (Object object : json.getJSONArray("stages")) {
            JSONObject jsonObject = (JSONObject) object;
            stages.put(jsonObject.getInt("duration"),jsonObject);
        }
        TreeMap<Integer, JSONObject> fatStages = findFatStages(stages);
        for (JSONObject stage :fatStages.values()) {
            analyst.analyze(stage);
        }
        return result;
    }

    private TreeMap<Integer, JSONObject> findFatStages(TreeMap<Integer, JSONObject> stages){
        TreeMap<Integer, JSONObject> fatStages = new TreeMap<>(Collections.reverseOrder());
        long subDuration=0;
        long stagesDuration=0;
        for(Map.Entry<Integer, JSONObject> entry : stages.entrySet()) {
            stagesDuration+=entry.getKey();
        }
        Set<Map.Entry<Integer, JSONObject>> set = stages.entrySet();
        Iterator<Map.Entry<Integer, JSONObject>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, JSONObject> entry = iterator.next();
            subDuration+=entry.getKey();
            fatStages.put(entry.getKey(),entry.getValue());
            if(((double)subDuration)/stagesDuration>=ALPHA){
                break;
            }
        }
        return fatStages;
    }
}
