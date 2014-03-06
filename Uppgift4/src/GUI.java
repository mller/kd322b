import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI extends JFrame {

	Human human;
	Dog dog;
	final JTextArea textArea;
	final JTextArea textArea_1;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnPrintInfo;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 41, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 76, 116, 22);
		contentPane.add(textField_1);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(12, 158, 56, 16);
		contentPane.add(lblInfo);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 187, 408, 22);
		contentPane.add(textArea);
		
		JLabel lblErrormessage = new JLabel("ErrorMessage");
		lblErrormessage.setBounds(12, 240, 136, 16);
		contentPane.add(lblErrormessage);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(12, 269, 408, 22);
		contentPane.add(textArea_1);
		
		JButton btnNewHuman = new JButton("Ny människa");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(textField.getText().isEmpty()){
				textArea_1.setText("Fältet kan inte vara tomt");
			}
				
			else if (textField.getText().length() < 3){
				textArea.setText(" ");
				textArea_1.setText("Namnet på ägaren måste ha minst 3 karaktärer!");
			}
			else{
				textArea_1.setText(" ");
				human = new Human(textField.getText());
			}
		}
		});
		btnNewHuman.setBounds(140, 40, 160, 25);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Köp hund");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()){
					textArea.setText(" ");
					textArea_1.setText("En hund måste ha en ägare!");					
				}
				else if(human != null){
					textArea_1.setText(" ");
					dog = new Dog(textField_1.getText());
					human.buyDog(dog);
				}
				else{
					textArea.setText(" ");
					textArea_1.setText("En hund måste ha en ägare!");
				}
			}
		});
		btnBuyDog.setBounds(140, 75, 160, 25);
		contentPane.add(btnBuyDog);
		
		btnPrintInfo = new JButton("Print info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(human.getInfo());
			}
		});
		btnPrintInfo.setBounds(140, 113, 160, 25);
		contentPane.add(btnPrintInfo);
		
		JLabel lblHumanAndDogs = new JLabel("Human and dogs");
		lblHumanAndDogs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHumanAndDogs.setBounds(12, 12, 178, 16);
		contentPane.add(lblHumanAndDogs);
	}
}
