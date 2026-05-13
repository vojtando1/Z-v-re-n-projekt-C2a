import java.awt.*;

public class PositiveObject extends GameObject {

    public PositiveObject(int x) {
        super(x, 0);
    }

    @Override
    void update() {
        y += speed;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 20, 20);
    }
}