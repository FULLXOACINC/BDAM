package by.zhuk.bdam.exception;

public class WriteConfigException extends Exception {
    public WriteConfigException() {
        super();
    }

    public WriteConfigException(String message) {
        super(message);
    }

    public WriteConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriteConfigException(Throwable cause) {
        super(cause);
    }

    protected WriteConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
