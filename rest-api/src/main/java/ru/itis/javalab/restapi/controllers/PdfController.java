package ru.itis.javalab.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.restapi.dto.UserInfoDTO;
import ru.itis.javalab.restapi.services.PdfInfoService;
import ru.itis.javalab.restapi.services.PdfService;

import java.security.Principal;

/**
 * @author Киямдинов Ильдар
 * @project app
 * @created 06.01.2022
 */

@Controller
@RequestMapping("statement")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private PdfInfoService pdfInfoService;

    @PostMapping(value = "{statementType}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@RequestBody UserInfoDTO userInfoDTO,
                                              @PathVariable String statementType,
                                              @AuthenticationPrincipal String username) {

        byte[] arr = pdfService.generatePdf(userInfoDTO, statementType);
        pdfInfoService.save(userInfoDTO, username, statementType);

        return ResponseEntity.ok(arr);
    }

}
