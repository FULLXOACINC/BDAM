package by.zhuk.bdam.sender.core;

import by.zhuk.bdam.domain.core.Report;
import by.zhuk.bdam.sender.core.ReportSender;

public class ConsoleReportSender implements ReportSender {

    @Override
    public void sendReport(Report report) {
        System.out.println(report.toReadableString());
    }
}
