package by.zhuk.bdam.exception;

public class ParseConfigFileException extends RuntimeException {
    public ParseConfigFileException(Exception e) {
        super(e);
    }

    public ParseConfigFileException(String s) {
        super(s);
    }
}
