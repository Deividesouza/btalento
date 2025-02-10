package com.example.btalento.model;

import jakarta.persistence.*;

public class PessoaFisicaTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pessoaFisicaTipo;


}


