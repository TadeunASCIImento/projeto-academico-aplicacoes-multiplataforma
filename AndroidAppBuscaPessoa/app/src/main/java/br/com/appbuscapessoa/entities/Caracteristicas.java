package br.com.appbuscapessoa.entities;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Root
public class Caracteristicas extends Entitie implements Serializable {


    @ElementList(name="caracteristica",inline = true,required = false)
    public List<Caracteristica>caracteristicas = new ArrayList<> ();


    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
