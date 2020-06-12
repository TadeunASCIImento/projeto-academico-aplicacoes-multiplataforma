package br.com.appbuscapessoa.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Date;

@Root(name="caracteristica")
public class Caracteristica extends Entitie implements Serializable {

    @Element(name="idCaracteristica",required = false)
    private Integer idCaracteristica;

    @Element(name="idInstituicaofk",required = false)
    private Integer idInstituicaofk;

    @Element(name="idade",required = false)
    private Integer idade;

    @Element(name="dataRegistro",required = false)
    private String dataRegistro;

    @Element(name="sexo",required = false)
    private String sexo;

    @Element(name="pele",required = false)
    private String pele;

    @Element(name="tipoCabelo",required = false)
    private String tipoCabelo;

    @Element(name="barba",required = false)
    private String barba;

    @Element(name="deficiencia",required = false)
    private String deficiencia;

    @Element(name="altura",required = false)
    private Double altura;

    @Element(name="olhos",required = false)
    private String olhos;

    @Element(name="corCabelo",required = false)
    private String corCabelo;

    @Element(name="fisico",required = false)
    private String fisico;

    @Element(name="tatuagens",required = false)
    private String tatuagens;

    @Element(name="cicatrizes",required = false)
    private String cicatrizes;

    @Element(name="observacao",required = false)
    private String observacao;

    @Element(name="fotoBase64",required = false)
    private String fotoBase64;

    public Caracteristica() {

    }

    public Caracteristica(Integer idCaracteristica, Integer idInstituicaofk, Integer idade, String dataRegistro,
                          String sexo, String pele, String tipoCabelo, String barba, String deficiencia, Double altura, String olhos,
                          String corCabelo, String fisico, String tatuagens, String cicatrizes, String observacao,
                          String fotoBase64) {
        super();
        this.idCaracteristica = idCaracteristica;
        this.idInstituicaofk = idInstituicaofk;
        this.idade = idade;
        this.dataRegistro = dataRegistro;
        this.sexo = sexo;
        this.pele = pele;
        this.tipoCabelo = tipoCabelo;
        this.barba = barba;
        this.deficiencia = deficiencia;
        this.altura = altura;
        this.olhos = olhos;
        this.corCabelo = corCabelo;
        this.fisico = fisico;
        this.tatuagens = tatuagens;
        this.cicatrizes = cicatrizes;
        this.observacao = observacao;
        this.fotoBase64 = fotoBase64;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracterisitca) {
        this.idCaracteristica = idCaracterisitca;
    }

    public Integer getIdInstituicaofk() {
        return idInstituicaofk;
    }

    public void setIdInstituicaofk(Integer idInstituicaofk) {
        this.idInstituicaofk = idInstituicaofk;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public String getTipoCabelo() {
        return tipoCabelo;
    }

    public void setTipoCabelo(String tipoCabelo) {
        this.tipoCabelo = tipoCabelo;
    }

    public String getBarba() {
        return barba;
    }

    public void setBarba(String barba) {
        this.barba = barba;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getOlhos() {
        return olhos;
    }

    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public String getFisico() {
        return fisico;
    }

    public void setFisico(String fisico) {
        this.fisico = fisico;
    }

    public String getTatuagens() {
        return tatuagens;
    }

    public void setTatuagens(String tatuagens) {
        this.tatuagens = tatuagens;
    }

    public String getCicatrizes() {
        return cicatrizes;
    }

    public void setCicatrizes(String cicatrizes) {
        this.cicatrizes = cicatrizes;
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

}
