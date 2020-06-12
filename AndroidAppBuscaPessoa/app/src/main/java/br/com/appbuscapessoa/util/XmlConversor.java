package br.com.appbuscapessoa.util;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.Serializable;
import java.io.StringWriter;



import br.com.appbuscapessoa.entities.Entitie;

public class XmlConversor implements Serializable {

    public String toXML(Entitie entitie){
        StringWriter out = new StringWriter ();
        try {
            Serializer serializer = new Persister ();
            serializer.write (entitie, out);
        }catch (Exception e){
            e.printStackTrace ();
        }
       return out.toString ();
    }

    public <T> T fromXML(Class<T> classe, String xml) {

        try {
            Serializer serializer = new Persister ();
            return serializer.read(classe, xml);
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    }

