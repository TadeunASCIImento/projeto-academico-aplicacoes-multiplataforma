package br.com.desaparecidos.daos;

import java.util.List;

import br.com.desaparecidos.entities.Entitie;

public interface DaoFunctions {

	boolean add(Entitie entitie);

	Entitie findOne(Entitie entitie);

	String findImage(Integer id);

	List<Entitie> findAll(Entitie entitie);

}
