package phonebook;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.SAXException;

public class AppView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JLabel lblNewLabel;
	private JTextField textNume;
	private JTextField textEmail;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnDeleteMsg;
	private JLabel lblFrom;
	private JComboBox comboBox;
	private JLabel lblTo;
	private JComboBox comboBox_1;
	private JTextArea textMesajScris;
	private JButton btnInsertInDb;
	private JButton btnNewButton_4;
	private JButton btnImportfromXmlMesaj;
	private JButton btnExportToXmlMsg;
	private JButton btnImportFromXmlContact;
	private JButton btnExportToXmlContact;
	private JTextArea textMesajFromXml;
	private JLabel lblFromXml;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppView frame = new AppView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AppView() {
		setMinimumSize(new Dimension(800, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1112, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.gridheight = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		contentPane.add(table, gbc_table);

		JLabel lblNume = new JLabel("Nume");
		GridBagConstraints gbc_lblNume = new GridBagConstraints();
		gbc_lblNume.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNume.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume.gridx = 2;
		gbc_lblNume.gridy = 0;
		contentPane.add(lblNume, gbc_lblNume);

		textNume = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		contentPane.add(textNume, gbc_textField);
		textNume.setColumns(10);

		table_1 = new JTable();
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridwidth = 2;
		gbc_table_1.gridheight = 3;
		gbc_table_1.insets = new Insets(0, 0, 5, 5);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 4;
		gbc_table_1.gridy = 0;
		contentPane.add(table_1, gbc_table_1);

		lblFrom = new JLabel("From");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.anchor = GridBagConstraints.NORTH;
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.gridx = 6;
		gbc_lblFrom.gridy = 0;
		contentPane.add(lblFrom, gbc_lblFrom);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 7;
		gbc_comboBox.gridy = 0;
		contentPane.add(comboBox, gbc_comboBox);

		lblNewLabel = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.weighty = 1.0;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		textEmail = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 1;
		contentPane.add(textEmail, gbc_textField_1);
		textEmail.setColumns(10);

		lblTo = new JLabel("TO:");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 6;
		gbc_lblTo.gridy = 1;
		contentPane.add(lblTo, gbc_lblTo);

		comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 7;
		gbc_comboBox_1.gridy = 1;
		contentPane.add(comboBox_1, gbc_comboBox_1);

		lblFromXml = new JLabel("From/To XML");
		GridBagConstraints gbc_lblFromXml = new GridBagConstraints();
		gbc_lblFromXml.insets = new Insets(0, 0, 5, 5);
		gbc_lblFromXml.gridx = 2;
		gbc_lblFromXml.gridy = 2;
		contentPane.add(lblFromXml, gbc_lblFromXml);

		textMesajFromXml = new JTextArea();
		GridBagConstraints gbc_textMesajFromXml = new GridBagConstraints();
		gbc_textMesajFromXml.insets = new Insets(0, 0, 5, 5);
		gbc_textMesajFromXml.fill = GridBagConstraints.BOTH;
		gbc_textMesajFromXml.gridx = 3;
		gbc_textMesajFromXml.gridy = 2;
		contentPane.add(textMesajFromXml, gbc_textMesajFromXml);

		textMesajScris = new JTextArea();
		GridBagConstraints gbc_textMesajScris = new GridBagConstraints();
		gbc_textMesajScris.gridwidth = 2;
		gbc_textMesajScris.weighty = 100.0;
		gbc_textMesajScris.weightx = 100.0;
		gbc_textMesajScris.insets = new Insets(0, 0, 5, 0);
		gbc_textMesajScris.fill = GridBagConstraints.BOTH;
		gbc_textMesajScris.gridx = 7;
		gbc_textMesajScris.gridy = 2;
		contentPane.add(textMesajScris, gbc_textMesajScris);

		JButton btnNewButton = new JButton("Refresh Contacts");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.weightx = 1.0;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		btnNewButton_3 = new JButton("Delete Contacts");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.weightx = 1.0;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 3;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);

		btnNewButton_2 = new JButton("Insert in DB");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector<Contact> v = new Vector<Contact>();
				Contact ct = new Contact();
				ct.setNume(textNume.getText());
				ct.setEmail(textEmail.getText());
				v.add(ct);
				try {
					insertContactIntoDB(v);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 3;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Refresh mesages");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.weightx = 1.0;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 3;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		btnDeleteMsg = new JButton("Delete msg.");
		GridBagConstraints gbc_btnDeleteMsg = new GridBagConstraints();
		gbc_btnDeleteMsg.weightx = 1.0;
		gbc_btnDeleteMsg.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteMsg.gridx = 5;
		gbc_btnDeleteMsg.gridy = 3;
		contentPane.add(btnDeleteMsg, gbc_btnDeleteMsg);

		btnInsertInDb = new JButton("Insert in DB");
		GridBagConstraints gbc_btnInsertInDb = new GridBagConstraints();
		gbc_btnInsertInDb.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertInDb.gridx = 7;
		gbc_btnInsertInDb.gridy = 3;
		contentPane.add(btnInsertInDb, gbc_btnInsertInDb);

		btnNewButton_4 = new JButton("Send");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 8;
		gbc_btnNewButton_4.gridy = 3;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);

		btnImportFromXmlContact = new JButton("Import from xml");
		btnImportFromXmlContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {importFromXmlContact();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnImportToXml = new GridBagConstraints();
		gbc_btnImportToXml.insets = new Insets(0, 0, 0, 5);
		gbc_btnImportToXml.gridx = 0;
		gbc_btnImportToXml.gridy = 4;
		contentPane.add(btnImportFromXmlContact, gbc_btnImportToXml);

		btnExportToXmlContact = new JButton("Export to xml");
		btnExportToXmlContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportToXmlContact(); 
			}
		});
		
		GridBagConstraints gbc_btnExportToXml = new GridBagConstraints();
		gbc_btnExportToXml.insets = new Insets(0, 0, 0, 5);
		gbc_btnExportToXml.gridx = 1;
		gbc_btnExportToXml.gridy = 4;
		contentPane.add(btnExportToXmlContact, gbc_btnExportToXml);

		btnImportfromXmlMesaj = new JButton("Import msg. from xml");
		btnImportfromXmlMesaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {importFromXmlMesaj();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 4;
		gbc_btnNewButton_5.gridy = 4;
		contentPane.add(btnImportfromXmlMesaj, gbc_btnNewButton_5);

		btnExportToXmlMsg = new JButton("Export msg. to xml");
		btnExportToXmlMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					exportToXmlMesaj();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} 
			}
		});
		GridBagConstraints gbc_btnExportMsg = new GridBagConstraints();
		gbc_btnExportMsg.insets = new Insets(0, 0, 0, 5);
		gbc_btnExportMsg.gridx = 5;
		gbc_btnExportMsg.gridy = 4;
		contentPane.add(btnExportToXmlMsg, gbc_btnExportMsg);
	}

	String pathContact = "C:\\Users\\stef\\Desktop\\Agenda.xml";
	String pathMesaj = "C:\\Users\\stef\\Desktop\\Mesaje.xml";
	
	public CitireXml getXmlConnection(String path)
			throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		InputStream xmlInput = new FileInputStream(path);
		SAXParser saxParser = factory.newSAXParser();
		CitireXml handler = new CitireXml();
		saxParser.parse(xmlInput, handler);
		return handler;
	}
	
	private void importFromXmlContact() throws Throwable{

			Contact c;
			CitireXml handler = getXmlConnection(pathContact);
			Vector<Contact> v = new Vector<Contact>();
			v = handler.getEntitati();
			c = v.get(0);
			textNume.setText(c.getNume());
			textEmail.setText(c.getEmail());
	
	}

	public void exportToXmlContact() {
		Contact c1 = new Contact();
		try {
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = factory
					.createXMLStreamWriter(new FileWriter(pathContact));
			writer.writeStartDocument();
			c1.setNume(textNume.getText());
			c1.setEmail(textEmail.getText());
			c1.toXml(writer);
			writer.writeEndDocument();
			writer.flush();
			writer.close();

		} catch (Throwable x) {
			x.printStackTrace();
		}
	}
	
	public void importFromXmlMesaj() throws Throwable {
			Mesaj c;
			CitireXml handler = getXmlConnection(pathMesaj);
			Vector<Contact> v = new Vector<Contact>();
			v = handler.getEntitati();
			c = (Mesaj) v.get(0);
			textNume.setText(c.getNume());
			textEmail.setText(c.getEmail());
			textMesajFromXml.setText(c.getMesaj());
	}
		
	public void exportToXmlMesaj() throws Throwable{
		Mesaj m = new Mesaj();
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = factory
					.createXMLStreamWriter(new FileWriter(pathMesaj));
			writer.writeStartDocument();
			m.setNume(textNume.getText());
			m.setEmail(textEmail.getText());
			m.setMesaj(textMesajFromXml.getText());
			m.toXml(writer);
			writer.writeEndDocument();
			writer.flush();
			writer.close();
	}
	
	private static Connection getDbConnection() throws Throwable {
		Connection c = null;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:agenda.db");
		return c;
	}

	private static void insertContactIntoDB(Vector<Contact> v) throws Throwable {
		// insert into DB
		Connection c = getDbConnection();
		for (int i = 0; i < v.size(); i++) {
			v.get(i).saveToDB(c);
		}
		c.close();
	}
}
