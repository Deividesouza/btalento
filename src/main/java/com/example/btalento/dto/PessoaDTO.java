package com.example.btalento.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
public class PessoaDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime dataValidade;
    private PessoaStatusDTO pessoaStatus;

}
