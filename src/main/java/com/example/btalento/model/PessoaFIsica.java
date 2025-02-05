package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity(name = "pessoa_fisica")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaFIsica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cpf;

    private String celular;

    private String login;

    private String senha;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private PessoaFisicaTipo pessoaFisicaTipo;

    @Enumerated(EnumType.STRING)
    private PerfilAcesso perfilAcesso;

}
