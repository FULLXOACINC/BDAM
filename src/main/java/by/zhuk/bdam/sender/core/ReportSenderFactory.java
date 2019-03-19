package by.zhuk.bdam.sender.core;


import by.zhuk.bdam.domain.core.AppType;

public interface ReportSenderFactory {
    enum SenderType {
        MAIL,HTML,CONSOLE
    }
    public static boolean contains(String test) {

        for (AppType type : AppType.values()) {
            if (type.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
    ReportSender createReportSenderByAppArgs(SenderType type,String[] param);
}