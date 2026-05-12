import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class CatchGame extends JPanel implements KeyListener {

    // hráč
    int playerX = 200;

    // score + životy
    int score = 0;
    int lives = 3;

    // herní objekty
    ArrayList<GameObject> objects = new ArrayList<>();

    Random rand = new Random();

    // balanced spawn lanes
    int[] lanes = {20, 100, 180, 260, 340};

    // anti-spawn systém
    int[] lastSpawn = new int[lanes.length];
    int frame = 0;

    public CatchGame() {

        setFocusable(true);
        addKeyListener(this);

        Arrays.fill(lastSpawn, -1000);

        // ===== MAIN LOOP =====
        Timer timer = new Timer(30, e -> {

            frame++;

            // ===== SPAWN =====
            // nižší frekvence spawnování
            if (rand.nextInt(60) == 0) {

                int lane = rand.nextInt(lanes.length);

                // balanced spawn
                if (frame - lastSpawn[lane] > 20) {

                    lastSpawn[lane] = frame;

                    if (rand.nextBoolean())
                        objects.add(new PositiveObject(lanes[lane]));
                    else
                        objects.add(new NegativeObject(lanes[lane]));
                }
            }

            // ===== UPDATE =====
            for (GameObject obj : objects) {
                obj.update();
            }

            // ===== KOLIZE =====
            Rectangle player = new Rectangle(playerX, 550, 80, 10);

            Iterator<GameObject> it = objects.iterator();

            while (it.hasNext()) {

                GameObject obj = it.next();

                // chycení objektu
                if (obj.getBounds().intersects(player)) {

                    if (obj instanceof PositiveObject)
                        score++;

                    if (obj instanceof NegativeObject)
                        lives--;

                    it.remove();
                }

                // objekt propadl
                else if (obj.y > 600) {

                    if (obj instanceof PositiveObject)
                        lives--;

                    it.remove();
                }
            }

            repaint();
        });

        timer.start();
    }

    // ===== VYKRESLENÍ =====
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // pozadí
        setBackground(Color.BLACK);

        // hráč
        g.setColor(Color.WHITE);
        g.fillRect(playerX, 550, 80, 10);

        // objekty
        for (GameObject obj : objects) {
            obj.draw(g);
        }

        // UI
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Lives: " + lives, 10, 40);

        // game over
        if (lives <= 0) {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 160, 300);
        }
    }

    // ===== OVLÁDÁNÍ =====
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            playerX -= 20;

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            playerX += 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    // ===== MAIN =====
    public static void main(String[] args) {

        JFrame frame = new JFrame("Catch Game");

        CatchGame game = new CatchGame();

        frame.add(game);

        frame.setSize(400, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}