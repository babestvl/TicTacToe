import java.awt.Button;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		setSize(300, 372);
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

		Container boardField = new Container();
		boardField.setLocation(0, 60);
		boardField.setLayout(new GridLayout(9,9));
		boardField.setSize(300, 289);
		for(int i = 0 ; i < 9 ; i++){
			for(int j = 0 ; j < 9 ; j++){
				final int x = i;
				final int y = j;
				JButton square = new JButton(" ");
				square.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						markField(x, y);
					}
				});
				boardField.add(square);
			}
		}
		
		contentPane.add(infoField);
		contentPane.add(boardField);
		setContentPane(contentPane);
	}
	
	private void markField(int x, int y){
		System.out.println("X: "+x+" Y: "+y);
	}

}
