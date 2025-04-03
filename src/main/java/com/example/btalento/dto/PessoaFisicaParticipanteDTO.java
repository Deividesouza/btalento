package com.example.btalento.dto;


import com.example.btalento.model.Pessoa;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.model.PessoaFisicaParticipante;
import lombok.Data;

@Data
public class PessoaFisicaParticipanteDTO {
    Pessoa pessoa;
    PessoaFisica pessoaFisica;
    PessoaFisicaParticipante pessoaFisicaParticipante;
}
