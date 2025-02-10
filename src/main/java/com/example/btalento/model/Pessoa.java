package com.example.btalento.model;

import com.example.btalento.enums.PessoaStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "pessoa")
@Table (name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String Email;

    private Date dataCadastro;

    private Date dataValidade;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private PessoaStatus pessoaStatus;
}
