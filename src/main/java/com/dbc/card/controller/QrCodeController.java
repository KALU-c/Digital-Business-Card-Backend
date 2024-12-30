package com.dbc.card.controller;

import com.dbc.card.model.ContactData;
import com.dbc.card.service.QrCodeService;
import com.dbc.card.util.VCardGenerator;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/qrcode")
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @PostMapping
    public ResponseEntity<byte[]> generateQrCode(@RequestBody ContactData contactData) {
        try {
            String vCard = VCardGenerator.generateVCard(contactData);
            String filePath = qrCodeService.generateAndSaveQrCode(vCard, 300, 300);

            byte[] qrCodeImage = Files.readAllBytes(Paths.get(filePath));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentDispositionFormData("attachment", "qrcode.png");

            return new ResponseEntity<>(qrCodeImage, headers, HttpStatus.OK);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
