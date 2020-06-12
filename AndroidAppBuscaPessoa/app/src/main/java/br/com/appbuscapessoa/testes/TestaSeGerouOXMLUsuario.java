package br.com.appbuscapessoa.testes;

import br.com.appbuscapessoa.entities.Usuario;
import br.com.appbuscapessoa.util.XmlConversor;

public class TestaSeGerouOXMLUsuario {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        usuario.setId (0);
        usuario.setCpf ("32471527841");
        usuario.setNome ("Tadeu");
        usuario.setEmail ("tadeu@gmail.com");
        usuario.setSenha ("destroyer");
        String xml = new XmlConversor ().toXML (usuario);
        System.out.println (xml);
        Usuario usuarioNovo = new XmlConversor ().fromXML (Usuario.class,xml);
        System.out.println (usuarioNovo.getEmail ());
        System.out.println (usuarioNovo.getSenha ());


    }
}
