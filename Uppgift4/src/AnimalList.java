import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;


public class AnimalList extends JFrame {

	ArrayList<Animal> animals;
	private JPanel contentPane;
	private Dog2 dog;
	private Cat cat;
	private Snake snake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalList frame = new AnimalList();
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
	public AnimalList() {
		setTitle("Animal list");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
	
		animals = new ArrayList<Animal>();
		animals.add(dog = new Dog2("Bert",3,true));
		animals.add(cat = new Cat("Bert 2",4,5));
		animals.add(dog = new Dog2("Bert 3",6,false));
		animals.add(cat = new Cat("Bert 4",6,9));
		animals.add(snake = new Snake("Bert 5",false));
		animals.add(cat = new Cat("Bert 6",4,2));
		animals.add(snake = new Snake("August",true));
		
		for(Animal a: animals){
			textArea.append((a.getInfo())+"\n");
		}
	}

}
