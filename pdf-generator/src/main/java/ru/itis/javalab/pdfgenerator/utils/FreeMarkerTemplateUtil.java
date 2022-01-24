package ru.itis.javalab.pdfgenerator.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.javalab.pdfgenerator.entities.User;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;

/**
 * @author Киямдинов Ильдар
 * @project app
 * @created 07.01.2022
 */

@Component
public class FreeMarkerTemplateUtil implements TemplateUtil {

    @Autowired
    private Configuration configuration;

    @Override
    public String generatePage(User user, String statementType) {

        String userName = user.getFirstName() + " " + user.getLastName();
        Map<String, String> model = Collections.singletonMap("name", userName);

        try (StringWriter stringWriter = new StringWriter()) {

            Template template = configuration.getTemplate(statementType + ".ftlh");
            template.process(model, stringWriter);

            return stringWriter.toString();

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

}
