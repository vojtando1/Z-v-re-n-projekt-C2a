import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {

    public GamePanel() {

        setTitle("Catch Game");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        JButton play = new JButton("PLAY");
        JButton exit = new JButton("EXIT");

        panel.add(play);
        panel.add(exit);

        add(panel);

        play.addActionListener(e -> {

            dispose();

            JFrame frame = new JFrame("Catch Game");

            CatchGame game = new CatchGame();

            frame.add(game);

            frame.setSize(400, 600);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
        });

        exit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
