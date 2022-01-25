package ru.itis.javalab.restapi.services;

import com.sun.corba.se.spi.orb.ParserDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.restapi.dto.UserInfoDTO;
import ru.itis.javalab.restapi.entities.PdfInfo;
import ru.itis.javalab.restapi.repos.PdfInfoRepository;

import java.util.Locale;

/**
 * @author Киямдинов Ильдар
 * @project rest-api
 * @created 24.01.2022
 */

@Service
public class PdfInfoServiceImpl implements PdfInfoService {

    @Autowired
    private PdfInfoRepository pdfInfoRepository;

    @Override
    public void save(UserInfoDTO userInfoDTO, String username, String statementType) {

        PdfInfo pdfInfo = PdfInfo.builder()
                .username(username)
                .firstName(userInfoDTO.getFirstName())
                .lastName(userInfoDTO.getLastName())
                .statementType(PdfInfo.StatementType.valueOf(statementType.toUpperCase()))
                    .build();

        pdfInfoRepository.save(pdfInfo);
    }

}
