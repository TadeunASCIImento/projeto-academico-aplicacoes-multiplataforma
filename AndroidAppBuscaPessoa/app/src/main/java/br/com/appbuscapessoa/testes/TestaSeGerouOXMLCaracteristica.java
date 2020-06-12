package br.com.appbuscapessoa.testes;

import java.util.Date;

import br.com.appbuscapessoa.entities.Caracteristica;

import br.com.appbuscapessoa.util.XmlConversor;

public class TestaSeGerouOXMLCaracteristica {

    public static void main(String[] args) {

        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setIdCaracteristica(1);
        caracteristica.setDataRegistro ("01/06/2020");
        caracteristica.setSexo("Masculino");
        caracteristica.setAltura(1.17);
        caracteristica.setBarba("Barba por fazer");
        caracteristica.setCicatrizes("Sem cicatrizes");
        caracteristica.setCorCabelo("Castanhos escuros");
        caracteristica.setDeficiencia("Sem deficiência");
        caracteristica.setFisico("Magro");
        caracteristica.setIdade(35);
        caracteristica.setIdInstituicaofk(26);
        caracteristica.setOlhos("Castanhos escuros");
        caracteristica.setTatuagens("Sem tatuagens");
        caracteristica.setPele("Parda");
        caracteristica.setTipoCabelo("Carapinha");
        caracteristica.setObservacao ("Sem observções");
        caracteristica.setFotoBase64 ("foto base64");

        String xml = new XmlConversor ().toXML (caracteristica);
        System.out.println (xml);

        Caracteristica caracteristica1 = new XmlConversor ().fromXML (Caracteristica.class,xml);
        System.out.println (caracteristica1.getIdCaracteristica ());
        System.out.println (caracteristica1.getDataRegistro ());
        System.out.println (caracteristica1.getIdInstituicaofk ());
        System.out.println (caracteristica1.getSexo ());
        System.out.println (caracteristica1.getTipoCabelo ());
        System.out.println (caracteristica1.getCicatrizes ());
        System.out.println (caracteristica1.getAltura ());
        System.out.println (caracteristica1.getBarba ());
        System.out.println (caracteristica1.getCorCabelo ());
        System.out.println (caracteristica1.getDeficiencia ());
        System.out.println (caracteristica1.getFisico ());
        System.out.println (caracteristica1.getFotoBase64 ());
        System.out.println (caracteristica1.getObservacao ());
        System.out.println (caracteristica1.getOlhos ());
        System.out.println (caracteristica1.getTatuagens ());



    }
}
