package by.zhuk.bdam.writer;

import by.zhuk.bdam.exception.WriteFileException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONObjectFileWriter {
    public void write(JSONObject jsonObject, String file) throws WriteFileException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonObject.toString());
        } catch (IOException e) {
            throw new WriteFileException(e);
        }
    }
}
