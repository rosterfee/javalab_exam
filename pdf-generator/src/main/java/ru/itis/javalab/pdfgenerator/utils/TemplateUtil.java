package ru.itis.javalab.pdfgenerator.utils;

import ru.itis.javalab.pdfgenerator.entities.User;

/**
 * @author Киямдинов Ильдар
 * @project app
 * @created 07.01.2022
 */

public interface TemplateUtil {

    String generatePage(User user, String statementType);

}
