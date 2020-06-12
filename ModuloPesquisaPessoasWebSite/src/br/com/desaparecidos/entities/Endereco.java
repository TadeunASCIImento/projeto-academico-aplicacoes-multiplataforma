package br.com.desaparecidos.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "endereco")
@XmlAccessorType(XmlAccessType.FIELD)
public class Endereco extends Entitie implements Serializable {
	private static final long serialVersionUID = -3171538758672023743L;

	@XmlElement(name = "idEndereco")
	private Integer idEndereco;

	@XmlElement(name = "cep")
	private String cep;

	@XmlElement(name = "logradouro")
	private String logradouro;

	@XmlElement(name = "bairro")
	private String bairro;

	@XmlElement(name = "cidade")
	private String cidade;

	public Endereco(Integer idEndereco, String cep, String logradouro, String bairro, String cidade) {
		super();
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Endereco() {

	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

}
