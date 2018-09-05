package shape;

import java.awt.*;

public class MyPoint extends Point {
    public int x;
    public int y;

    public MyPoint() {}

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 平移
     * @param dx x方向的移动距离
     * @param dy y方向的移动距离
     */
    public void move(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    /**
     * 旋转
     * @param alpha 旋转角度
     */
    public void rotate(int alpha) {
        double rad = (float) alpha / 180 * Math.PI;
        int x1 = x;
        int y1 = y;
        x = (int) (x1 * Math.cos(rad) - y1 * Math.sin(rad));
        y = (int) (x1 * Math.sin(rad) + y1 * Math.cos(rad));
    }

    public String toString() {
        String string = "(" + x + "," + y + ")";

        return string;
    }


}
