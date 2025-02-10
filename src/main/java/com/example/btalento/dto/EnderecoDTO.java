package com.example.btalento.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String logradouro;
    private String cep;
    private String complemento;
    private String numeroCasa;
    private CidadeDTO cidade;

}
