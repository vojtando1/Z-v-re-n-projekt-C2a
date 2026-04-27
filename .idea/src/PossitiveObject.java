import java.awt.*;

class PositiveObject extends GameObject {

    PositiveObject(int x) {
        this.x = x; this.y = 0;
    }

    void update() {
        y += speed;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 20, 20);
    }
}