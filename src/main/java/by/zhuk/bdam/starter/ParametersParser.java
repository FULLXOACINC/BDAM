package by.zhuk.bdam.starter;

import java.util.HashMap;
import java.util.Map;

public class ParametersParser {
    private Map<String, String> result = new HashMap<>();

    public ParametersParser() {
        result.put("--app_type", null);
        result.put("--config_file", null);
        result.put("--new_config_file", null);
        result.put("--sender_type", "Console");
        result.put("--is_run_app", "true");
    }

    public Map<String, String> parseParameters(String[] args) {
        String kay;
        for (int index = 0; index < args.length; index ++) {
            StringBuilder value = new StringBuilder();
            kay=args[index];
            index++;
            for (;index < args.length; index++) {
                value.append(args[index]);
                if (index + 1 < args.length) {
                    if (result.containsKey(args[index + 1])) {
                        break;
                    } else {
                        value.append(" ");
                    }
                }


            }
            result.put(kay, value.toString());
        }
        return result;
    }

}
