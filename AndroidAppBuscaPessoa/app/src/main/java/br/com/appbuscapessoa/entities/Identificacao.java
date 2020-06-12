package br.com.appbuscapessoa.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import java.io.Serializable;

@Root(name="identificacao")
public class Identificacao extends Entitie implements Serializable {

    @Element(name="dataRegistro",required = false)
    private String dataRegistro;

    @Element(name="documento",required = false)
    private String documento;

    @Element(name="idIdentificacao",required = false)
    private Integer idIdentificacao;

    @Element(name="idInstituicaofk",required = false)
    private Integer idInstituicaofk;

    @Element(name="nome",required = false)
    private String nome;

    @Element(name="nomeMae",required = false)
    private String nomeMae;

    @Element(name="nomePai" ,required = false)
    private String nomePai;

    @Element(name="observacao",required = false)
    private String observacao;

    @Element(name="fotoBase64",required = false)
    private String fotoBase64;

    public Identificacao(Integer idIdentificacao, String documento, String nome, String nomePai, String nomeMae,
                         String dataRegistro, Integer idInstituicaofk, String observacao, String fotoBase64) {
        super();
        this.idIdentificacao = idIdentificacao;
        this.documento = documento;
        this.nome = nome;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.dataRegistro = dataRegistro;
        this.idInstituicaofk = idInstituicaofk;
        this.observacao = observacao;
        this.fotoBase64 = fotoBase64;
    }

    public Identificacao() {

    }

    public Integer getIdIdentificacao() {
        return idIdentificacao;
    }

    public void setIdIdentificacao(Integer idIdentificacao) {
        this.idIdentificacao = idIdentificacao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    public Integer getIdInstituicaofk() {
        return idInstituicaofk;
    }

    public void setIdInstituicaofk(Integer idInstituicaofk) {
        this.idInstituicaofk = idInstituicaofk;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    @Override
    public String toString() {
        return "Identificacao{" +
                "documento='" + documento + '\'' +
                ", idIdentificacao=" + idIdentificacao +
                ", idInstituicaofk=" + idInstituicaofk +
                ", nome='" + nome + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", nomePai='" + nomePai + '\'' +
                ", observacao='" + observacao + '\'' +
                ", fotoBase64='" + fotoBase64 + '\'' +
                '}';
    }


}
