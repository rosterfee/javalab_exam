package ru.itis.javalab.pdfgenerator.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.css.apply.ICssApplierFactory;
import com.itextpdf.html2pdf.css.apply.impl.DefaultCssApplierFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.javalab.pdfgenerator.entities.User;
import ru.itis.javalab.pdfgenerator.utils.TemplateUtil;

import java.io.*;

/**
 * @author Киямдинов Ильдар
 * @project app
 * @created 06.01.2022
 */

@Component
public class PdfGenerateConsumer {

    @Autowired
    private TemplateUtil templateUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = {"vacation", "dismissal"}, containerFactory = "containerFactory")
    public byte[] generatePdf(Message message) {

        String statementType = message.getMessageProperties().getReceivedRoutingKey();

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            String userJson = new String(message.getBody());
            User user = objectMapper.readValue(userJson, User.class);

            String html = templateUtil.generatePage(user, statementType);

            ConverterProperties properties = new ConverterProperties();

            HtmlConverter.convertToPdf(html, out, properties);

            return out.toByteArray();

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
