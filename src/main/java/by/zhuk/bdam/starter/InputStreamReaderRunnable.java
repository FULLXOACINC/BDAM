package by.zhuk.bdam.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderRunnable implements Runnable {

    private static Logger logger = LogManager.getLogger(InputStreamReaderRunnable.class);

    private String name;
    private BufferedReader reader;


    public InputStreamReaderRunnable(InputStream is, String name) {
        this.name = name;
        this.reader = new BufferedReader(new InputStreamReader(is));
        logger.info("InputStreamReaderRunnable:  name=" + name);
    }

    @Override
    public void run() {
        try {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
        catch (Exception e) {
            logger.error("run() failed. for name="+ name, e);
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                logger.error( e);
            }
        }
    }
}
