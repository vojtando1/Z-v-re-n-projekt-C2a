import java.awt.*;

abstract class GameObject {

    int x, y;
    int speed = 5;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void update();
    abstract void draw(Graphics g);

    Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }
}