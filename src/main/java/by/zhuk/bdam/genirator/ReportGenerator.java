package by.zhuk.bdam.genirator;

import by.zhuk.bdam.domain.core.Report;

public interface ReportGenerator<T, K, V> {
    Report generateReport(T metric, K solution, V config);
}
