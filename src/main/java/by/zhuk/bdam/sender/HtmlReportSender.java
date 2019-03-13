package by.zhuk.bdam.sender;

import by.zhuk.bdam.domain.core.Report;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HtmlReportSender implements ReportSender {
    private static final String TEMPLATE_FILE_PATH = "templates/spark_report_notification.twig";
    private String storePath;
    public HtmlReportSender(String storePath) {
        this.storePath = storePath;
    }

    @Override
    public void sendReport(Report report) {
        JtwigTemplate template = JtwigTemplate.classpathTemplate(TEMPLATE_FILE_PATH);
        JtwigModel model = JtwigModel.newModel().with("report", report);
        String body = template.render(model);
        try (PrintWriter out = new PrintWriter(storePath)) {
            out.println(body);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
