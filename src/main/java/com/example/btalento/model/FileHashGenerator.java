package com.example.btalento.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileHashGenerator {

    public static String generateFileNameHash(String fileName) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(fileName.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar o hash do nome do arquivo", e);
        }
    }
}

