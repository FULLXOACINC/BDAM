package by.zhuk.bdam.exception;

public class ReportSendException extends Exception {
    public ReportSendException() {
        super();
    }

    public ReportSendException(String message) {
        super(message);
    }

    public ReportSendException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportSendException(Throwable cause) {
        super(cause);
    }

    protected ReportSendException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
