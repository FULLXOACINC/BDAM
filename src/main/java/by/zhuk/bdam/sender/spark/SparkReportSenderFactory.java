package by.zhuk.bdam.sender.spark;


import by.zhuk.bdam.sender.core.ConsoleReportSender;
import by.zhuk.bdam.sender.core.ReportSender;
import by.zhuk.bdam.sender.core.ReportSenderFactory;

public class SparkReportSenderFactory implements ReportSenderFactory {

    @Override
    public ReportSender createReportSenderByAppArgs(SenderType type, String[] param) {
        if (type.equals(SenderType.HTML)) {
            return new SparkHtmlReportSender(param[param.length-1]);
        }
        if (type.equals(SenderType.MAIL)) {
            return new SparkMailReportSender(param[param.length-1]);
        }
        return new ConsoleReportSender();
    }
}
