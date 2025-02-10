package com.example.btalento.dto;

import com.example.btalento.enums.PerfilAcesso;
import com.example.btalento.enums.PessoaFisicaTipo;
import com.example.btalento.enums.PessoaStatus;
import lombok.Data;

import java.util.Date;

@Data
public class PessoaFisicaDTO {
    private Long pessoaId; // ID da Pessoa
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String celular;
    private String login;
    private String senha;
    private PessoaFisicaTipo pessoaFisicaTipo;
    private PerfilAcesso perfilAcesso;
    private Long enderecoId;  // ID do endereço
    private PessoaStatus pessoaStatus;
    private Date dataValidade; // Adicionando data de validade

    // Novos campos para o endereço
    private String cidadeNome;   // Nome da cidade
    private String cidadeUfSigla; // Sigla da UF
    private String logradouro;    // Logradouro
    private String cep;           // CEP
    private int numeroCasa;    // Número da casa
}
