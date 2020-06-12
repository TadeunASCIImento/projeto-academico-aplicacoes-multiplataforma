package br.com.desaparecidos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Identificacao extends Entitie implements Serializable {

	private static final long serialVersionUID = 3018680340560912669L;

	@XmlElement(required = true)
	private Integer idIdentificacao;

	@XmlElement(required = true)
	private String documento;

	@XmlElement(required = true)
	private String nome;

	@XmlElement(required = true)
	private String nomePai;

	@XmlElement(required = true)
	private String nomeMae;

	@XmlElement(required = true)
	private Date dataRegistro;

	@XmlElement(required = true)
	private Integer idInstituicaofk;

	@XmlElement(required = true)
	private String observacao;

	@XmlElement(required = true)
	private String fotoBase64;

	public Identificacao(Integer idIdentificacao, String documento, String nome, String nomePai, String nomeMae,
			Date dataRegistro, Integer idInstituicaofk, String observacao, String fotoBase64) {
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

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
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

}
