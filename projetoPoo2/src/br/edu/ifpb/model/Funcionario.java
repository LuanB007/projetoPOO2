package br.edu.ifpb.model;

import java.time.LocalDate;
import java.util.Objects;
/**
 * Classe que contêm os dados do funcionário.
 * @author Luan
 */
public class Funcionario {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate nascimento;
    private String setor;
    private String usuario;
    private String senha;

    /**
     * Construtor da classe funcionário.
     * @param nome nome do funcionário.
     * @param cpf CPF do funcionário.
     * @param email email pessoal do funcionário.
     * @param telefone telefone do funcionário.
     * @param nascimento data de nascimento do funcionário.
     * @param setor setor que o funcionário está alocado.
     * @param usuario usuario usado para fazer login no sistema.
     * @param senha senha usada para fazer login no sistema.
     */
    public Funcionario(String nome, String cpf, String email, String telefone, LocalDate nascimento, String setor, String usuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.setor = setor;
        this.usuario = usuario;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.telefone);
        hash = 89 * hash + Objects.hashCode(this.nascimento);
        hash = 89 * hash + Objects.hashCode(this.setor);
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.setor, other.setor)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", nascimento=" + nascimento + ", setor=" + setor + ", usuario=" + usuario + '}';
    }
 
}