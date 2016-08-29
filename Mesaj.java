package phonebook;

import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


@SuppressWarnings("restriction")
public class Mesaj extends Contact {

	protected String mesaj;

	public Mesaj() {
	}

	public Mesaj(String nume, String email, String mesaj) {
		super(nume, email);
		this.mesaj = mesaj;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}

	public void toXml(XMLStreamWriter writer) throws Exception {

		writer.writeStartElement("Agenda");
		writer.writeStartElement("Mesaj");

		writer.writeStartElement("Nume");
		writer.writeCharacters(nume);
		writer.writeEndElement();

		writer.writeStartElement("Email");
		writer.writeCharacters(email);
		writer.writeEndElement();

		writer.writeStartElement("Text");
		writer.writeCharacters(mesaj);
		writer.writeEndElement();

		writer.writeEndElement();
		writer.writeEndElement();
	}

	public void startElement(String uri, String localName, String qName, Attributes atribute) throws SAXException {
		lastElement = qName;
	}

	public void characters(char[] ch, int start, int length) throws SAXException {

		String value = new String(ch, start, length);
		if (value.length() == 0)
			return; // ignore white space

		if (lastElement.equals("Nume")) {
			setNume(value);
		} else if (lastElement.equals("Email")) {
			setEmail(value);
		} else if (lastElement.equals("Text")) {
			setMesaj(getMesaj() == null ? value : getMesaj() + value);
		}
	}

}
