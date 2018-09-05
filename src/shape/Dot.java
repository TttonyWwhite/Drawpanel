package shape;


import gui.ColorHandler;

import java.awt.*;

public class Dot extends Shape {

    private int num;

    public Dot() {}

    public Dot(Color color, int width, int x1, int y1, int x2, int y2) {
        super(color, width, x1, y1, x2, y2);
    }

    public String toString() {return "Dot:" + super.toString();}

    public void DrawShape(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(lineWidth));
        int i = 0, j = 1;

        while(points.size() > i) {
            g.drawLine(points.elementAt(i).x, points.elementAt(i).y, points.elementAt(j).x, points.elementAt(j).y);
            i = i + 2;
            j = j + 2;
        }

        g.setColor(ColorHandler.color);
    }

    public void addPoint(int x1, int y1, int x2, int y2) {
        points.add(new MyPoint(x1, y1));
        points.add(new MyPoint(x2, y2));
    }

    public void setColorWidth(Color color1, int width) {
        lineWidth = width;
        color = color1;
    }
}
