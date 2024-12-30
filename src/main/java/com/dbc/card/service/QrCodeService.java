package com.dbc.card.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

import com.google.zxing.EncodeHintType;
import java.util.Map;

@Service
public class QrCodeService {

    public String generateAndSaveQrCode(String content, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, Map.of(EncodeHintType.MARGIN, 1));

        String fileName = UUID.randomUUID().toString() + ".png";
        String directory = "qrcodes/";
        new File(directory).mkdirs(); // Ensure directory exists

        Path path = Path.of(directory + fileName);
        try (FileOutputStream outputStream = new FileOutputStream(path.toFile())) {
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        }

        return path.toString();
    }
}
