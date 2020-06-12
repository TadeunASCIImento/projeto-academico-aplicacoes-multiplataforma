package br.com.desaparecidos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Identificacoes extends Entitie implements Serializable {

	private static final long serialVersionUID = 7199771342970882134L;

	@XmlElement(name = "identificacao")
	private List<Identificacao> identificacoes = new ArrayList<>();

	public List<Identificacao> getIdentificacoes() {
		return identificacoes;
	}

	public void setIdentificacoes(List<Identificacao> identificacoes) {
		this.identificacoes = identificacoes;
	}

}
