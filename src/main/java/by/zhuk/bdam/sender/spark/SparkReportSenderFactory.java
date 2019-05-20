package by.zhuk.bdam.sender.spark;


import by.zhuk.bdam.exception.CreateSenderException;
import by.zhuk.bdam.sender.core.ConsoleReportSender;
import by.zhuk.bdam.sender.core.ReportSender;
import by.zhuk.bdam.sender.core.ReportSenderFactory;

public class SparkReportSenderFactory implements ReportSenderFactory {

    @Override
    public ReportSender createReportSenderByAppArgs(SenderType type, String param) throws CreateSenderException {
        String[] params = param.split(" ");
        if(params.length==1){
            return new ConsoleReportSender();
        }
        if (type.equals(SenderType.HTML)) {
            return new SparkHtmlReportSender(params[1]);
        }
        if (type.equals(SenderType.MAIL)) {
            return new SparkMailReportSender(params[1]);
        }else {
            throw new CreateSenderException("Not found sender type"+type);
        }

    }
}
