package by.zhuk.bdam.mail;


import by.zhuk.bdam.exception.ParseConfigFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class include mail properties information
 */
public class MailProperty {
    private static final String HOST = "mail.smtp.host";
    private static final String PORT = "mail.smtp.port";
    private static final String NAME = "mail.user.name";
    private static final String PASSWORD = "mail.user.password";

    private static Properties properties = new Properties();

    static {
        init("mail.properties");
    }

    private MailProperty() {
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void init(String filePath) throws ParseConfigFileException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new ParseConfigFileException(e);
        }
        if (!MailPropertiesValidator.isSMTPHostValid(properties.getProperty(HOST))) {
            throw new ParseConfigFileException("Not valid in config file mail.smtp.host");
        }
        if (!MailPropertiesValidator.isSMTPPortValid(properties.getProperty(PORT))) {
            throw new ParseConfigFileException("Not valid in config file mail.smtp.port");
        }
        if (properties.getProperty(NAME) == null) {
            throw new ParseConfigFileException("Not valid in config file mail.user.name");
        }
        if (properties.getProperty(PASSWORD) == null) {
            throw new ParseConfigFileException("Not valid in config file mail.user.password");
        }
    }
}