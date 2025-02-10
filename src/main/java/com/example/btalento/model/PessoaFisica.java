package com.example.btalento.model;


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

    @OneToOne
    @JoinColumn(name = "pessoa_fisica_tipo")
    private PessoaFisicaTipo pessoaFisicaTipo;

    @OneToOne
    @JoinColumn(name = "perfil_acesso_id")
    private com.example.btalento.model.PerfilAcesso perfilAcesso;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;  // Relação com a entidade Pessoa

}
