package br.com.appbuscapessoa.entities;


import java.io.Serializable;

public class Registro extends Entitie implements Serializable {

    private byte[] foto;
    private Integer registro;
    private String data;
    private String documento;
    private String filiacaoPai;
    private String filiacaoMAe;
    private String nome;
    private String instituicao;
    private String endereco;
    private String cep;
    private String bairro;
    private String cidade;
    private String telefone;
    private String observacao;

    public Registro(){

    }


    public Registro(Integer registro, String data, String documento, String filiacaoPai, String filiacaoMAe, String nome, String instituicao, String endereco, String cep, String bairro, String cidade, String telefone, String observacao) {
        this.registro = registro;
        this.data = data;
        this.documento = documento;
        this.filiacaoPai = filiacaoPai;
        this.filiacaoMAe = filiacaoMAe;
        this.nome = nome;
        this.instituicao = instituicao;
        this.endereco = endereco;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Integer getRegistro() {
        return registro;
    }

    public void setRegistro(Integer registro) {
        this.registro = registro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFiliacaoPai() {
        return filiacaoPai;
    }

    public void setFiliacaoPai(String filiacaoPai) {
        this.filiacaoPai = filiacaoPai;
    }

    public String getFiliacaoMAe() {
        return filiacaoMAe;
    }

    public void setFiliacaoMAe(String filiacaoMAe) {
        this.filiacaoMAe = filiacaoMAe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
