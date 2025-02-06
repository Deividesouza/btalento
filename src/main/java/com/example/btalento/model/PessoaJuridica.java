package com.example.btalento.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    private String telcomercial;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private PessoaJuridicaTipo pessoaJuridicaTipo;

    @ManyToMany
    @JoinTable(
            name = "pessoa_juridica_Cursos",  // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "pessoa_juridica_id"),  // Chave estrangeira para Endereco
            inverseJoinColumns = @JoinColumn(name = "cursos_id")  // Chave estrangeira para Cidade
    )
    private List<Cursos> cursos;

}
