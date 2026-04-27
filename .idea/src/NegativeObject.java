import java.awt.*;

class NegativeObject extends GameObject {
    NegativeObject(int x) {
        this.x = x; this.y = 0;
    }

    void update() {
        y += speed;
    }

    void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
    }
}