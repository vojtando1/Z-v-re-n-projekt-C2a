import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CatchGame extends JPanel implements KeyListener {

    int playerX = 200;

    public CatchGame() {
        setFocusable(true);
        addKeyListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(playerX, 550, 80, 10);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) playerX -= 20;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) playerX += 20;
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Catch Game");
        CatchGame game = new CatchGame();
        frame.add(game);
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}