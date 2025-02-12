package com.example.btalento.dto;

import com.example.btalento.model.Pessoa;
import com.example.btalento.model.PessoaFisica;
import lombok.Data;

@Data
public class PessoaFisicaDTO {

    private Pessoa  pessoa;
    private PessoaFisica pessoaFisica;

}
