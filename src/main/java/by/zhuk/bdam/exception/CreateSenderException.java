package by.zhuk.bdam.exception;

public class CreateSenderException extends Exception {
    public CreateSenderException() {
        super();
    }

    public CreateSenderException(String message) {
        super(message);
    }

    public CreateSenderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateSenderException(Throwable cause) {
        super(cause);
    }

    protected CreateSenderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
