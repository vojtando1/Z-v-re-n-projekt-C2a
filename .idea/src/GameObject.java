import java.awt.*;

abstract class GameObject {
    int x, y;
    int speed = 5;

    abstract void update();
    abstract void draw(Graphics g);

    Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }
}
