import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.AbstractListModel;
import javax.swing.JTable;


public class BikeStoreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;
	BikeStore bikeStore = new BikeStore();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BikeStoreGUI frame = new BikeStoreGUI();
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
	public BikeStoreGUI() {
		/**Adds some bikes to the array*/
		bikeStore.addBike("red", 20, 2500);
		bikeStore.addBike("green", 18, 2100);
		bikeStore.addBike("black", 22, 2800);
		bikeStore.addBike("white", 17, 2000);
		bikeStore.addBike("green", 20, 1900);
		bikeStore.addBike("black", 15, 1800);
		bikeStore.addBike("red", 29, 3100);
		bikeStore.addBike("yellow", 21, 2600);
		bikeStore.addBike("blue", 18, 1900);
		bikeStore.addBike("black", 12, 1300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBikesInThe = new JLabel("Bikes in the store");
		lblBikesInThe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBikesInThe.setBounds(12, 13, 356, 43);
		contentPane.add(lblBikesInThe);
		
		JLabel lblAddNewBike = new JLabel("Add new bike");
		lblAddNewBike.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNewBike.setBounds(380, 106, 181, 43);
		contentPane.add(lblAddNewBike);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(448, 153, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(448, 188, 116, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(448, 223, 116, 22);
		contentPane.add(textField_2);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblColor.setBounds(380, 156, 56, 16);
		contentPane.add(lblColor);
		
		JLabel lblTireSize = new JLabel("Tire size:");
		lblTireSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTireSize.setBounds(380, 191, 56, 16);
		contentPane.add(lblTireSize);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(380, 226, 56, 16);
		contentPane.add(lblPrice);
		
		textArea = new JTextArea();
		textArea.setText(bikeStore.getAllBikes());
		textArea.setBounds(12, 68, 356, 372);
		contentPane.add(textArea);
		
		/**When 'Save' is pressed, the method addBike is called and a new bike is created with the parameters the user put in the text fields.*/
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bikeStore.addBike(textField.getText(),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()));
				/**The text area is updated with the bikes*/
				textArea.setText(bikeStore.getAllBikes());
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(380, 258, 182, 25);
		contentPane.add(btnSave);
		
		JButton btnDeleteMarkedBikes = new JButton("Delete marked bikes");
		btnDeleteMarkedBikes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteMarkedBikes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteMarkedBikes.setBounds(380, 68, 182, 25);
		contentPane.add(btnDeleteMarkedBikes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(379, 106, 182, 9);
		contentPane.add(separator);
	}
}
