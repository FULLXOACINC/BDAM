package by.zhuk.bdam.sender;

import by.zhuk.bdam.domain.Report;

import java.util.List;

public interface ReportSender {
    void sendReports(List<Report> reports);
}
