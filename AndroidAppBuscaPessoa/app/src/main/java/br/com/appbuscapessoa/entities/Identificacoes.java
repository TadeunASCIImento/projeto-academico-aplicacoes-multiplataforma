package br.com.appbuscapessoa.entities;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Root
public class Identificacoes extends Entitie implements Serializable {

	@ElementList(name="identificacao",inline = true,required = false)
	public List<Identificacao> identificacoes = new ArrayList<>();

	public List<Identificacao> getIdentificacoes() {
		return identificacoes;
	}
	public void setIdentificacoes(List<Identificacao> identificacoes) {
		this.identificacoes = identificacoes;
	}

}
