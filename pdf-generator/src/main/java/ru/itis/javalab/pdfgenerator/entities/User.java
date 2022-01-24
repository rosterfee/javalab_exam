package ru.itis.javalab.pdfgenerator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Киямдинов Ильдар
 * @project app
 * @created 07.01.2022
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String firstName;
    private String lastName;

}
