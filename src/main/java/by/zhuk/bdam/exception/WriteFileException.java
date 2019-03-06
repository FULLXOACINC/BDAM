package by.zhuk.bdam.exception;

public class WriteFileException extends Exception {
    public WriteFileException() {
        super();
    }

    public WriteFileException(String message) {
        super(message);
    }

    public WriteFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriteFileException(Throwable cause) {
        super(cause);
    }

    protected WriteFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
