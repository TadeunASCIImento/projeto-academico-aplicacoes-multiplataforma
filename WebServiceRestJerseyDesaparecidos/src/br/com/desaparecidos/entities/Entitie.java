package br.com.desaparecidos.entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({ Usuario.class, Identificacao.class,Instituicao.class })
public abstract class Entitie {


}
