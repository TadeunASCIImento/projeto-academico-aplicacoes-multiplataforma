package br.com.appbuscapessoa.testes;

import br.com.appbuscapessoa.entities.Identificacao;
import br.com.appbuscapessoa.entities.Identificacoes;
import br.com.appbuscapessoa.servicos.URLConstantsHTTP;
import br.com.appbuscapessoa.util.XmlConversor;

public class TestaSeGerouOXMLIdentificacao {

    public static void main(String[] args) {

        Identificacao identificacao = new Identificacao();
        //dentificacao.setDataRegistro (new Date ());
        identificacao.setDocumento("32471527841");
        identificacao.setNome("Tadeu do Nascimento");
        identificacao.setNomePai("Edilson do Nascimento");
        identificacao.setNomeMae("Adelice Francisca de Oliveira");

        String xml = new XmlConversor ().toXML (identificacao);
        System.out.println (xml);

        try {
            String resposta = new HttpServiceTestePOST ().sendPOST (URLConstantsHTTP.URL_BUSCAR_IDENTIFICACAO,xml);
            System.out.println (resposta);
            Identificacoes identificacoes = new XmlConversor ().fromXML (Identificacoes.class,resposta);
            System.out.println (identificacoes.getIdentificacoes ().size ());

            for ( Identificacao identificacao1:identificacoes.getIdentificacoes ()) {
                Integer idIdentificacao = identificacao1.getIdIdentificacao ();
                identificacao.setIdIdentificacao (idIdentificacao);
                System.out.println (identificacao1.getIdIdentificacao ());
                System.out.println (identificacao1.getDocumento ());
                System.out.println (identificacao1.getNome ());
                System.out.println (identificacao1.getNomeMae ());
                System.out.println (identificacao1.getNomePai ());
                System.out.println (identificacao1.getIdInstituicaofk ());
                System.out.println (identificacao1.getObservacao ());
                xml = new XmlConversor ().toXML (identificacao);
                resposta = new HttpServiceTestePOST ().sendPOST (URLConstantsHTTP.URL_FOTO_IDENTIFICACAO,xml);

            }
            System.out.println (resposta);

        } catch (HttpServiceTestePOST.MinhaException e) {
            e.printStackTrace ();
        }


    }
}
