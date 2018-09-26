package shape;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Tag {
    private JLabel label;

    private int x;
    private int y;
    private int w;
    private int h;

    public Tag() {}

    public Tag(JLabel label, int x, int y, int w, int h) {
        this.label = label;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Tag(FileReader fileReader) throws IOException {
        char[] c = new char[10];

        fileReader.read(c, 0, 10);
        int type = Integer.parseInt(new String(c));
        if(type == 1)
            label = new JLabel("圆形");
        else if (type == 2)
            label = new JLabel("三角形");
        else if (type == 3)
            label = new JLabel("矩形");

        fileReader.read(c, 0, 10);
        x = Integer.parseInt(new String(c));

        fileReader.read(c, 0, 10);
        y = Integer.parseInt(new String(c));

        fileReader.read(c, 0, 10);
        w = Integer.parseInt(new String(c));

        fileReader.read(c, 0, 10);
        h = Integer.parseInt(new String(c));
    }

    public void output(PrintWriter printWriter) {
        printWriter.printf("T");
        switch (label.getText()) {
            case "圆形":
                printWriter.printf("%010d", 1);
                break;
            case "三角形":
                printWriter.printf("%010d", 2);
                break;
            case "矩形":
                printWriter.printf("%010d", 3);
                break;
        }
        printWriter.printf("%010d%010d%010d%010d\r\n",  x, y, w, h);
    }

    public JLabel getLabel() {
        return label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
