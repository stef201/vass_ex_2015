package phonebook;

import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@SuppressWarnings("restriction")
public class Contact extends DefaultHandler {

	protected String nume;
	protected String email;
	protected String lastElement;

	public Contact() {

	}

	public Contact(String nume, String email) {
		this.nume = nume;
		this.email = email;
	}

	public String getNume() {
		return nume;
	}

	public String getEmail() {
		return email;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void toXml(XMLStreamWriter writer) throws Exception {

		writer.writeStartElement("Agenda");
		writer.writeStartElement("Contact");

		writer.writeStartElement("Nume");
		writer.writeCharacters(nume);
		writer.writeEndElement();

		writer.writeStartElement("Email");
		writer.writeCharacters(email);
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
		} 
	}

	
	void saveToDB(Connection c) throws SQLException {
		java.sql.Statement stmt = null;
		stmt = c.createStatement();
		String sql = "INSERT INTO CONTACTE (Nume,Email) " + "VALUES (" + this.commaSeparatedValues() + ");";
		System.out.println(sql);
		stmt.executeUpdate(sql);
		stmt.close();
	}

	private String commaSeparatedValues() {
		return  "\"" + nume + "\",\"" + email + "\"";
	}
}
