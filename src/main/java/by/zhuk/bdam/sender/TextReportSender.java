package by.zhuk.bdam.sender;

import by.zhuk.bdam.domain.Report;

import java.util.List;

public class TextReportSender implements ReportSender {
    private String storePath;

    public TextReportSender(String storePath) {
        this.storePath = storePath;
    }

    @Override
    public void sendReport(Report report) {
        System.out.println("TextReportSender");
    }
}
