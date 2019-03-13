package by.zhuk.bdam.mail;

/**
 * Class MailPropertiesValidator include method to validate mail properties
 */
class MailPropertiesValidator {
    private static final String SMTP_HOST_REGEX = "smtp\\.\\w+\\.\\w+";
    private static final String SMTP_PORT_REGEX = "\\d+";

    /**
     * Method allows to validate smtp host
     *
     * @return true if host valid else return false
     */
    static boolean isSMTPHostValid(String host) {
        return host != null && host.matches(SMTP_HOST_REGEX);
    }

    /**
     * Method allows to validate smtp port
     *
     * @return true if port valid else return false
     */
    static boolean isSMTPPortValid(String port) {
        return port != null && port.matches(SMTP_PORT_REGEX);
    }

}