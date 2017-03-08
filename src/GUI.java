import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {

	private JPanel contentPane;
	private Container boardField;
	private Container infoField;

	/**
	 * Create the frame.
	 */
	public GUI(Game g) {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(454, 512);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		infoField = new Container();
		infoField.setLocation(0, 0);
		infoField.setSize(450, 60);
		infoField.setLayout(null);
        JLabel currentPlayer = new JLabel("Player :");
        currentPlayer.setBounds(6, 6, 187, 48);
        Button button = new Button("Reset");
        button.setBounds(199, 15, 100, 29);
        button.addActionListener(e -> reset(g));
		infoField.add(currentPlayer);
		infoField.add(button);

        boardField = new Container();
        boardField.setLocation(2, 60);
        boardField.setLayout(new GridLayout(9,9));
        boardField.setSize(450, 450);
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                final int x = i;
                final int y = j;
                final JButton square = new JButton("");
                square.addActionListener(e -> markField(square, g, x, y));
                boardField.add(square);
            }
        }
		
		contentPane.add(infoField);
		contentPane.add(boardField);
		setContentPane(contentPane);
	}
	
	private void markField(JButton s, Game g, int x, int y) {
	    Player p = g.getPlayer();
        p.placeSymbol(g.getBoard(),x,y);
        s.setText(p.getSymValue() + "");
        s.setEnabled(false);
        if (g.check(x, y)) {
        	Component[] arr = boardField.getComponents();
        	for(Component a : arr){
        		a.setEnabled(false);
        	}
        }
    }

    private void reset(Game g) {
        g.resetGame();
        Component[] arr = boardField.getComponents();
        for(Component a : arr) {
            a.setEnabled(true);
            JButton b = (JButton)a;
            b.setText("");

        }
    }

}
