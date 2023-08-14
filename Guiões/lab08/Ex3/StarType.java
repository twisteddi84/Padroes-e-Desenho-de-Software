import java.awt.*;

public abstract class StarType {

    private int size;
    private Color color;
    protected String description;
    protected Float[] physicalProperties;
    private int x;
    private int y;

    public StarType(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y , size, size);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y= y;
    }
    
}
