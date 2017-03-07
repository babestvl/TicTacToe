import java.awt.*;

public class Main {
	
    public static void main(String[] args) {
        Game g = new Game(9, 9, "a", "b");
        EventQueue.invokeLater(() -> {
            try {
                GUI frame = new GUI(g);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
