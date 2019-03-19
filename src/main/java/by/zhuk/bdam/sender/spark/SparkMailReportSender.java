package by.zhuk.bdam.sender.spark;

import by.zhuk.bdam.domain.core.Report;
import by.zhuk.bdam.mail.MailProperty;
import by.zhuk.bdam.mail.MailSender;
import by.zhuk.bdam.sender.core.ReportSender;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

public class SparkMailReportSender implements ReportSender {
    private static final String templateFilePath = "templates/spark_report_notification.twig";
    private String sendToMails;

    SparkMailReportSender(String sendToMails) {
        this.sendToMails = sendToMails;
    }

    @Override
    public void sendReport(Report report) {
        JtwigTemplate template = JtwigTemplate.classpathTemplate(templateFilePath);
        JtwigModel model = JtwigModel.newModel().with("report", report);
        String mailBody = template.render(model);
        MailSender sender = new MailSender(sendToMails, "Application analysis: " + report.getAppName(), mailBody, MailProperty.getProperties());
        sender.send();
    }
}
