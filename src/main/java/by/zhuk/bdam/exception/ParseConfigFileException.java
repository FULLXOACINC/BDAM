package by.zhuk.bdam.exception;

public class ParseConfigFileException extends Exception {
    public ParseConfigFileException(Exception e) {
        super(e);
    }

    public ParseConfigFileException(String s) {
        super(s);
    }
}
