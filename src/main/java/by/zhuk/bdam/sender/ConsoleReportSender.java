package by.zhuk.bdam.sender;

import by.zhuk.bdam.domain.core.Report;

public class ConsoleReportSender implements ReportSender {

    @Override
    public void sendReport(Report report) {
        System.out.println(report.toReadableString());
    }
}
