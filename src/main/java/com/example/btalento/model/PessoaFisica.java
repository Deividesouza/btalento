package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa_fisica")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String celular;
    private String login;
    private String senha;

    @OneToOne
    @JoinColumn(name = "pessoa_fisica_tipo_id")
    private PessoaFisicaTipo pessoaFisicaTipo;

    @OneToOne
    @JoinColumn(name = "perfil_acesso_id")
    private PerfilAcesso perfilAcesso;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
