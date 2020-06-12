package br.com.desaparecidos.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "instituicao")
@XmlAccessorType(XmlAccessType.FIELD)
public class Instituicao extends Entitie implements Serializable {

	private static final long serialVersionUID = 5832078743924359829L;

	@XmlElement(name = "idInstituicao")
	private Integer idInstituicao;

	@XmlElement(name = "idEnderecofk")
	private Integer idEnderecofk;

	@XmlElement(name = "nomeInstituicao")
	private String nome;

	@XmlElement(name = "telefone")
	private String telefone;

	public Instituicao(Integer idInstituicao, Integer idEnderecofk, String nome, String telefone) {
		super();
		this.idInstituicao = idInstituicao;
		this.idEnderecofk = idEnderecofk;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
