package com.example.btalento.controller;

import com.example.btalento.model.Curriculo;
import com.example.btalento.model.FileHashGenerator;
import com.example.btalento.model.PessoaFisicaParticipante;
import com.example.btalento.repository.CurriculoRepository;
import com.example.btalento.repository.PessoaFisicaParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/curriculos")
public class ArquivoController {

    @Autowired
    private CurriculoRepository curriculoRepository;

    @Autowired
    private PessoaFisicaParticipanteRepository participanteRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadCurriculo(
            @RequestParam("file") MultipartFile file,
            @RequestParam("participanteid") Long participanteid) {

        try {
            PessoaFisicaParticipante participante = participanteRepository.findById(participanteid)
                    .orElseThrow(() -> new RuntimeException("Participante não encontrado"));

            // Gerar hash do nome do arquivo
            String fileHash = gerarHash(file.getOriginalFilename());

            // Salvar arquivo fisicamente
            Path path = Paths.get(uploadDir + File.separator + fileHash);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            // Criar e salvar entidade Curriculo
            Curriculo curriculo = new Curriculo();
            curriculo.setPessoaFisicaParticipante(participante);
            curriculo.setNomeArquivoHash(fileHash);


            curriculoRepository.save(curriculo);

            return ResponseEntity.ok("Currículo salvo com sucesso");

        } catch (IOException | RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar currículo: " + e.getMessage());
        }
    }

    private String gerarHash(String fileName) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(fileName.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash", e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
