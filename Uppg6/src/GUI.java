import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JSeparator;


public class GUI extends JFrame {

	private JLabel lblBla;
	private JLabel lblBlabla;
	private JLabel lblBlablabla;
	private int men;
	private int women;

	private Bargraph bargraph;
	private Document doc;
	org.w3c.dom.Node node;
	private ArrayList<Program> programList = new ArrayList<Program>();
	private Document openXmlFile(String fileName){
		Document doc = null;
		try{
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return doc;
	}
	
	private ArrayList<Program> loadAllPrograms(){
		ArrayList<Program> output = new ArrayList<Program>();
		
		NodeList programs = doc.getElementsByTagName("Program");
		for(int i = 0;i<programs.getLength();i++){
			node = programs.item(i);
			Element elm = (Element) node;
			
			String name = elm.getElementsByTagName("name").item(0).getTextContent();
			String code = elm.getElementsByTagName("code").item(0).getTextContent();
			String women = elm.getElementsByTagName("women").item(0).getTextContent();
			String men = elm.getElementsByTagName("men").item(0).getTextContent();
			Program program = new Program(name, code, Integer.parseInt(women),Integer.parseInt(men));
			output.add(program);
		}
		return output;
	}
	
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		doc = openXmlFile("XML.xml");
		programList = loadAllPrograms();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(12, 13, 408, 16);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText("Antal program: "+loadAllPrograms().size());
		
		JLabel lblKursnamn = new JLabel("Kursnamn:");
		lblKursnamn.setBounds(12, 122, 62, 16);
		contentPane.add(lblKursnamn);
		
		JLabel lblKod = new JLabel("Kod:");
		lblKod.setBounds(12, 151, 56, 16);
		contentPane.add(lblKod);
		
		final JLabel lblBla = new JLabel("bla");
		lblBla.setBounds(86, 122, 334, 16);
		contentPane.add(lblBla);
		lblBla.setText("");
		
		final JLabel lblBlabla = new JLabel("blabla");
		lblBlabla.setBounds(86, 151, 334, 16);
		contentPane.add(lblBlabla);
		lblBlabla.setText("");
		
		JLabel lblTotaltAntalSkande = new JLabel("Totalt antal s\u00F6kande:");
		lblTotaltAntalSkande.setBounds(12, 195, 121, 16);
		contentPane.add(lblTotaltAntalSkande);
		
		final JLabel lblBlablabla = new JLabel("Blablabla");
		lblBlablabla.setBounds(145, 195, 56, 16);
		contentPane.add(lblBlablabla);
		lblBlablabla.setText("");
		
		bargraph = new Bargraph();
		bargraph.setBounds(73, 195, 280, 245);
		contentPane.add(bargraph);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblBla.setText(programList.get(comboBox.getSelectedIndex()).getName());
				lblBlabla.setText(programList.get(comboBox.getSelectedIndex()).getCode());
				men = programList.get(comboBox.getSelectedIndex()).getMen();
				women = programList.get(comboBox.getSelectedIndex()).getWomen();
				bargraph.updateValues(women, men);
			}
			
		});
		comboBox.setBounds(12, 42, 408, 22);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(programList.toArray()));
		
		JLabel lblDetaljer = new JLabel("Detaljer");
		lblDetaljer.setBounds(12, 92, 56, 16);
		contentPane.add(lblDetaljer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 77, 408, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 180, 408, 2);
		contentPane.add(separator_1);
		
	}
}
