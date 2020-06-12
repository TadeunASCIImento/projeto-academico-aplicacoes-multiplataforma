package br.com.appbuscapessoa.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name="usuario")
public class Usuario extends Entitie implements Serializable {

    @Element(name="id",required = false)
    private Integer id;

    @Element(name="nome",required = false)
    private String nome;

    @Element(name="cpf",required = false)
    private String cpf;

    @Element(name="email",required = false)
    private String email;

    @Element(name="senha",required = false)
    private String senha;

    public Usuario(Integer id, String nome, String cpf, String email, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
