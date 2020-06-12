package br.com.desaparecidos.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "instituicao")
@XmlAccessorType(XmlAccessType.FIELD)
public class Instituicao extends Entitie implements Serializable {

	private static final long serialVersionUID = -8006955533881715854L;
	private Integer idInstituicao;
	private Integer idEnderecofk;
	private String nomeInstituicao;
	private String telefone;

	public Instituicao(Integer idInstituicao, Integer idEnderecofk, String nomeInstituicao, String telefone) {
		super();
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
