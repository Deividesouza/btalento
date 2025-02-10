package com.example.btalento.model;

import com.example.btalento.enums.PerfilAcesso;
import com.example.btalento.enums.PessoaFisicaTipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "pessoa_fisica")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaFisica extends Pessoa{


    private String cpf;
    private String celular;
    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private PessoaFisicaTipo pessoaFisicaTipo;

    @Enumerated(EnumType.STRING)
    private PerfilAcesso perfilAcesso;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;  // Relação com a entidade Pessoa

}
