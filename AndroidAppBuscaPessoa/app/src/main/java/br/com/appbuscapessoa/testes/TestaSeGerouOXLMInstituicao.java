package br.com.appbuscapessoa.testes;

import br.com.appbuscapessoa.entities.Instituicao;
import br.com.appbuscapessoa.util.XmlConversor;

public class TestaSeGerouOXLMInstituicao {

    public static void main(String[] args) {

        Instituicao instituicao = new Instituicao();
        instituicao.setIdEnderecofk(26);
        instituicao.setIdInstituicao(26);
        instituicao.setNomeInstituicao("Hospital Municipal Infantil Menino Jesus");
        instituicao.setTelefone("3253-5200");
        String xml = new XmlConversor ().toXML (instituicao);
        System.out.println (xml);


        Instituicao novaInstituicao = new XmlConversor ().fromXML (Instituicao.class,xml);
        System.out.println (novaInstituicao.getIdInstituicao ());
        System.out.println (novaInstituicao.getIdEnderecofk ());
        System.out.println (novaInstituicao.getNomeInstituicao ());
        System.out.println (novaInstituicao.getTelefone ());
    }
}
