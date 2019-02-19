package by.zhuk.bdam.exception;

public class JobDumpException extends Exception {
    public JobDumpException() {
        super();
    }

    public JobDumpException(String message) {
        super(message);
    }

    public JobDumpException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobDumpException(Throwable cause) {
        super(cause);
    }

    protected JobDumpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
