package com.example.btalento.dto;

public class PessoaFisicaDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String celular;
    private String login;
    private String senha;
    private PessoaFisicaTipoDTO pessoaFisicaTipo;
    private PerfilAcessoDTO perfilAcesso;
    private PessoaDTO pessoaDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PessoaFisicaTipoDTO getPessoaFisicaTipo() {
        return pessoaFisicaTipo;
    }

    public void setPessoaFisicaTipo(PessoaFisicaTipoDTO pessoaFisicaTipo) {
        this.pessoaFisicaTipo = pessoaFisicaTipo;
    }

    public PerfilAcessoDTO getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcessoDTO perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    public PessoaDTO getPessoaDTO() {
        return pessoaDTO;
    }

    public void setPessoaDTO(PessoaDTO pessoaDTO) {
        this.pessoaDTO = pessoaDTO;
    }

    public static class PessoaDTO {
        private Long id;
        private String nome;
        private String telefone;
        private String email;
        private String pessoaStatus;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPessoaStatus() {
            return pessoaStatus;
        }

        public void setPessoaStatus(String pessoaStatus) {
            this.pessoaStatus = pessoaStatus;
        }
    }

    public static class PessoaFisicaTipoDTO {
        private String pessoaFisicaTipo;

        public String getPessoaFisicaTipo() {
            return pessoaFisicaTipo;
        }

        public void setPessoaFisicaTipo(String pessoaFisicaTipo) {
            this.pessoaFisicaTipo = pessoaFisicaTipo;
        }
    }

    public static class PerfilAcessoDTO {
        private String perfilAcesso;

        public String getPerfilAcesso() {
            return perfilAcesso;
        }

        public void setPerfilAcesso(String perfilAcesso) {
            this.perfilAcesso = perfilAcesso;
        }
    }
}
