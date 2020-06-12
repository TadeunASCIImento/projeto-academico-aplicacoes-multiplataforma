package br.com.appbuscapessoa.testes;

import br.com.appbuscapessoa.entities.Endereco;
import br.com.appbuscapessoa.util.XmlConversor;


public class TestaSeGerouOXMLEndereco {

    public static void main(String[] args) {

        Endereco endereco = new Endereco ();
        endereco.setCep ("1329000");
        endereco.setLogradouro ("Rua, dos Ingleses, 258");
        endereco.setBairro ("Bela Vista");
        endereco.setCidade ("São Paulo");
        endereco.setIdEndereco (1);
        String xml = new XmlConversor ().toXML (endereco);
        System.out.println (xml);

        Endereco endereco1 = new Endereco ();
        endereco1 = new XmlConversor ().fromXML (Endereco.class,xml);

        System.out.println (endereco1.getIdEndereco ());
        System.out.println (endereco1.getCep ());
        System.out.println (endereco1.getLogradouro ());
        System.out.println (endereco1.getBairro ());
        System.out.println (endereco1.getCidade ());


    }
}
