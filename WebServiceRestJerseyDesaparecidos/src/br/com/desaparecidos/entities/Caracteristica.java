package br.com.desaparecidos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Caracteristica extends Entitie implements Serializable {

	private static final long serialVersionUID = 1417838773317542039L;

	private Integer idCaracteristica;
	private Integer idInstituicaofk;
	private Integer idade;
	private Date dataRegistro;
	private String sexo;
	private String pele;
	private String tipoCabelo;
	private String barba;
	private String deficiencia;
	private Double altura;
	private String olhos;
	private String corCabelo;
	private String fisico;
	private String tatuagens;
	private String cicatrizes;
	private String observacao;
	private String fotoBase64;

	public Caracteristica() {

	}

	public Caracteristica(Integer idCaracteristica, Integer idInstituicaofk, Integer idade, Date dataRegistro,
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

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
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
