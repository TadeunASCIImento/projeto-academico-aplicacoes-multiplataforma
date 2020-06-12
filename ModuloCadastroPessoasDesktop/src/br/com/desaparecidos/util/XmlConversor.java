package br.com.desaparecidos.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamResult;

import br.com.desaparecidos.entities.Entitie;

public class XmlConversor {


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
			Marshaller m = null;
			m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			m.marshal(entitie, sw);
			return sw.toString();
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;

	}

}
