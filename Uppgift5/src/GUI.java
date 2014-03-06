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


public class GUI extends JFrame {

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
		doc = openXmlFile("C:\\Users\\tor\\Desktop\\Programering\\fil t uppg5.xml");
		programList = loadAllPrograms();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(12, 13, 408, 16);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText("Första elementet (rooten): "+doc.getDocumentElement().getNodeName());
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(12, 42, 408, 16);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText("Antal program: "+loadAllPrograms().size());
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox.setBounds(12, 71, 408, 22);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(programList.toArray()));
		
		JLabel lblDetaljer = new JLabel("Detaljer");
		lblDetaljer.setBounds(12, 106, 56, 16);
		contentPane.add(lblDetaljer);
	}
}
