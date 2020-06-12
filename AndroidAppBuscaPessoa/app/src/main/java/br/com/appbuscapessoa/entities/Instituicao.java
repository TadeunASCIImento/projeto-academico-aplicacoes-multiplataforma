package br.com.appbuscapessoa.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name="instituicao")
public class Instituicao extends Entitie implements Serializable {

    @Element(name="idInstituicao")
    private Integer idInstituicao;

    @Element(name="idEnderecofk",required = false)
    private Integer idEnderecofk;

    @Element(name="nomeInstituicao",required = false)
    private String nomeInstituicao;

    @Element(name="telefone",required = false)
    private String telefone;

    public Instituicao(Integer idInstituicao, Integer idEnderecofk, String nomeInstituicao, String telefone) {

        this.idInstituicao = idInstituicao;
        this.idEnderecofk = idEnderecofk;
        this.nomeInstituicao = nomeInstituicao;
        this.telefone = telefone;
    }

    public Instituicao() {
    }

    public Integer getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public Integer getIdEnderecofk() {
        return idEnderecofk;
    }

    public void setIdEnderecofk(Integer idEnderecofk) {
        this.idEnderecofk = idEnderecofk;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
