package ru.itis.javalab.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Киямдинов Ильдар
 * @project app
 * @created 06.01.2022
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO implements Serializable {

    private String firstName;
    private String lastName;

}
