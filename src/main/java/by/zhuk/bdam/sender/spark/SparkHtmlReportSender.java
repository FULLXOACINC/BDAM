package by.zhuk.bdam.sender.spark;

import by.zhuk.bdam.domain.core.Report;
import by.zhuk.bdam.exception.ReportSendException;
import by.zhuk.bdam.sender.core.ReportSender;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SparkHtmlReportSender implements ReportSender {
    private static final String TEMPLATE_FILE_PATH = "templates/spark_report_notification.twig";
    private String storePath;
    public SparkHtmlReportSender(String storePath) {
        this.storePath = storePath;
    }

    @Override
    public void sendReport(Report report) throws ReportSendException {
        JtwigTemplate template = JtwigTemplate.classpathTemplate(TEMPLATE_FILE_PATH);
        JtwigModel model = JtwigModel.newModel().with("report", report);
        String body = template.render(model);
        try (PrintWriter out = new PrintWriter(storePath)) {
            out.println(body);
        } catch (FileNotFoundException e) {
            throw new ReportSendException(e);
        }
    }
}
