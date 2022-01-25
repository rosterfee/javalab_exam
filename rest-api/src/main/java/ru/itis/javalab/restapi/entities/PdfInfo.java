package ru.itis.javalab.restapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

/**
 * @author Киямдинов Ильдар
 * @project rest-api
 * @created 24.01.2022
 */


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PdfInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatementType statementType;

    private String username;

    private String firstName;
    private String lastName;

    public enum StatementType {
        VACATION, DISMISSAL
    }

}
