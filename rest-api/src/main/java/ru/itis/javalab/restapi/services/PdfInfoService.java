package ru.itis.javalab.restapi.services;

import ru.itis.javalab.restapi.dto.UserInfoDTO;
import ru.itis.javalab.restapi.entities.PdfInfo;

/**
 * @author Киямдинов Ильдар
 * @project rest-api
 * @created 24.01.2022
 */

public interface PdfInfoService {

    void save(UserInfoDTO userInfoDTO, String username, String statementType);

}
