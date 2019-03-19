package by.zhuk.bdam.sender.core;

import by.zhuk.bdam.domain.core.Report;
import by.zhuk.bdam.exception.ReportSendException;

public interface ReportSender {
    void sendReport(Report report) throws ReportSendException;
}
