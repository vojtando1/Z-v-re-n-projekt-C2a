import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CatchGame extends JPanel implements KeyListener {

    int playerX = 200;
    int score = 0;
    int lives = 3;

    ArrayList<Rectangle> objects = new ArrayList<>();
    Random rand = new Random();

    public CatchGame() {
        setFocusable(true);
        addKeyListener(this);


        Timer timer = new Timer(30, e -> {

            if (rand.nextInt(20) == 0) {
                objects.add(new Rectangle(rand.nextInt(380), 0, 20, 20));
            }

            for (Rectangle r : objects) {
                r.y += 5;
            }
            Rectangle player = new Rectangle(playerX, 550, 80, 10);

            Iterator<Rectangle> it = objects.iterator();
            while (it.hasNext()) {
                Rectangle r = it.next();

                if (r.intersects(player)) {
                    score++;
                    it.remove();
                }
            }

            repaint();
        });
        timer.start();
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // hráč
        g.fillRect(playerX, 550, 80, 10);

        // objekty
        for (Rectangle r : objects) {
            g.fillRect(r.x, r.y, 20, 20);
        }
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Lives: " + lives, 10, 40);

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) playerX -= 20;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) playerX += 20;
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