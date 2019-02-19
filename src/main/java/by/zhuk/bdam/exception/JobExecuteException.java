package by.zhuk.bdam.exception;

public class JobExecuteException extends Exception {
    public JobExecuteException() {
        super();
    }

    public JobExecuteException(String message) {
        super(message);
    }

    public JobExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobExecuteException(Throwable cause) {
        super(cause);
    }

    protected JobExecuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
