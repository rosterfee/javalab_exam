package ru.itis.javalab.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.restapi.entities.User;
import ru.itis.javalab.restapi.services.PdfService;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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

    @PostMapping(value = "{statementType}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@RequestBody User user,
                                              @PathVariable String statementType) {
        byte[] arr = pdfService.generatePdf(user, statementType);
        System.out.println(Arrays.toString(arr));
        return ResponseEntity.ok(arr);
    }

}
