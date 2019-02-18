package by.zhuk.bdam.exception;

public class SparkJobExecuteException extends Exception {
    public SparkJobExecuteException() {
        super();
    }

    public SparkJobExecuteException(String message) {
        super(message);
    }

    public SparkJobExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SparkJobExecuteException(Throwable cause) {
        super(cause);
    }

    protected SparkJobExecuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
