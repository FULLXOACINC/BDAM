package by.zhuk.bdam.sender;

import by.zhuk.bdam.domain.core.Report;

public class HtmlReportSender implements ReportSender {
    private String storePath;

    public HtmlReportSender(String storePath) {
        this.storePath = storePath;
    }

    @Override
    public void sendReport(Report report) {
        System.out.println("HtmlReportSender");
    }
}
