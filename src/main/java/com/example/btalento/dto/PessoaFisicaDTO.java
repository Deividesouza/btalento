package com.example.btalento.dto;

import lombok.Data;

@Data
public class PessoaFisicaDTO {
    private String cpf;
    private String celular;
    private String login;
    private String senha;
    private String pessoaFisicaTipo; // Ajuste de String para o tipo correto se necessário
    private String perfilAcesso; // Ajuste de String para o tipo correto se necessário
    private EnderecoDTO enderecoDTO; // Certifique-se de que está criando o DTO correto
    private PessoaDTO pessoaDTO; // Certifique-se de que está criando o DTO correto
    private String cidadeUfSigla; // Sigla da UF
    private String ufNome; // Nome da UF
    private String cidadeNome; // Nome da cidade
}
