import java.awt.Button;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		Container infoField = new Container();
		infoField.setLocation(0, 0);
		infoField.setSize(300, 60);
		infoField.setLayout(null);
			JLabel currentPlayer = new JLabel("Player :");
			currentPlayer.setBounds(6, 6, 187, 48);
			Button button = new Button("Reset");
			button.setBounds(199, 15, 100, 29);
		infoField.add(currentPlayer);
		infoField.add(button);

		
		
		contentPane.add(infoField);
		
		setContentPane(contentPane);
	}

}
