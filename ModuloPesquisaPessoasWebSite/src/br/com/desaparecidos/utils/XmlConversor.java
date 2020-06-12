package br.com.desaparecidos.utils;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import br.com.desaparecidos.entities.Entitie;

public class XmlConversor implements Serializable {
	private static final long serialVersionUID = -510634755756775333L;

	public String marshal(Object object) {
		final StringWriter out = new StringWriter();
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(object.getClass());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(object, new StreamResult(out));
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return out.toString();
	}

	public String toXML(Entitie entitie) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(entitie.getClass());
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			m.marshal(entitie, sw);
			String xmlString = sw.toString();
			return xmlString;
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;

	}

	public <T> T xmlToObject(Class<T> classe, String xml) {
		try {
			JAXBContext context = JAXBContext.newInstance(classe);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), classe).getValue();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

}
