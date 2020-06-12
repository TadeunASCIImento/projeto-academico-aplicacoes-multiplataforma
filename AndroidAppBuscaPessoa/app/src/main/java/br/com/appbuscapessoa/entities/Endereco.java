package br.com.appbuscapessoa.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name="endereco")
public class Endereco extends Entitie implements Serializable {

	@Element(name="idEndereco")
	private Integer idEndereco;

	@Element(name="cep",required = false)
	private String cep;

	@Element(name="logradouro",required = false)
	private String logradouro;

	@Element(name="bairro",required = false)
	private String bairro;

	@Element(name="cidade",required = false)
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
