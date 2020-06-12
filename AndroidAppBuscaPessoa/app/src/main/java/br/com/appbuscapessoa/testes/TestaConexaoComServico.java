package br.com.appbuscapessoa.testes;

import br.com.appbuscapessoa.entities.Usuario;
import br.com.appbuscapessoa.servicos.URLConstantsHTTP;
import br.com.appbuscapessoa.util.XmlConversor;

public class TestaConexaoComServico {

    public static void main(String[] args) {

        Usuario usuario = new Usuario ();
        usuario.setEmail ("tadeunascimento@uni9.edu.br");
        usuario.setSenha ("administrador");
        String xml = new XmlConversor ().toXML (usuario);
        try {
            String resposta = new HttpServiceTestePOST ().sendPOST (URLConstantsHTTP.URL_VALIDAR_USUARIO, xml);
            System.out.println (xml);
            System.out.println (resposta);
        } catch (Exception exc) {
            exc.printStackTrace ();
        }
    }
}