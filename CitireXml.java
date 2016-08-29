package phonebook;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CitireXml extends DefaultHandler {
	Vector<Contact> v = new Vector<Contact>();
	Contact c;
	String lastElement;

	public void startElement(String uri, String localName, String qName, Attributes atribute) throws SAXException {
		lastElement = qName;
		if (qName.equals("Contact")) {
			c = new Contact();
		} else if (qName.equals("Mesaj")) {
			c = new Mesaj();
		} else if (qName.equals("Agenda")) {

		} else {
			c.startElement(uri, localName, qName, atribute);
		}

	}

	public void characters(char[] ch, int start, int length) throws SAXException {

		String value = new String(ch, start, length);
		if (value.length() == 0)
			return; // ignore white space
		if (lastElement.equals("Contact") || lastElement.equals("Mesaj") || lastElement.equals("Agenda")) {
		} else {
			c.characters(ch, start, length);
		}

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equals("Contact")) {
			v.add(c);
		} else if (qName.equals("Mesaj")) {
			v.add(c);
		}
	}

	public Vector<Contact> getEntitati() {
		return v;
	}

}
