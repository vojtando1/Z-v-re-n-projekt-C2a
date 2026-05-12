import java.awt.*;

class NegativeObject extends GameObject {

    public NegativeObject(int x) {
        super(x, 0);
    }

    @Override
    void update() {
        y += speed;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
    }
}