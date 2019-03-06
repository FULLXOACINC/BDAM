package by.zhuk.bdam.serializer;

import org.json.JSONObject;

public interface JsonSerializer<T> {
    JSONObject serialize(T t);
}
