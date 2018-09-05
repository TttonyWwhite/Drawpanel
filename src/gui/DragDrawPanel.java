package gui;

import listener.Tools;
import shape.Dot;
import shape.MyPoint;
import shape.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class DragDrawPanel extends JPanel implements MouseMotionListener, MouseListener {
    /**
     * 左上角
     */
    private Point Start = null;

    /**
     * 右上角
     */
    private Point Stop = null;

    /** 是否绘制虚线矩形* */
    private boolean dottedTag = true;

    /** 是否要判断图形类型 **/
    private boolean checkShape = false;

    private Color color;

    /** 笔画数统计 **/
    private int count = 0;

    public static int width = 1;

    public static int w = 0;

    public static int h = 0;

    Dot dot;

    public DragDrawPanel() {
        setPreferredSize(new Dimension(600, 600));
        Border border = new LineBorder(Color.black);
        setBorder(border);
        setBackground(color.white);
        Start = new MyPoint(0, 0);
        Stop = new MyPoint(0,0);
        dot = new Dot();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        color = ColorHandler.color;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        /** 宽度 **/
        w = Math.abs(Stop.x - Start.x);
        /** 高度 **/
        h = Math.abs(Stop.y - Start.y);

        /** 用起点终点的最小值作为起点 **/
        Point min = new Point(0, 0);
        min.x = Math.min(Stop.x, Start.x);
        min.y = Math.min(Stop.y, Start.y);

        for(shape.Shape shape : DrawShape.shapes) {
            g2.setStroke(new BasicStroke());
            shape.DrawShape(g2);
        }

        if(dottedTag) {
            Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.5f,
                    new float[] { 5, 5, }, 0f);

            g2.setStroke(dash);

            dot.DrawShape(g2);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        Stop = e.getPoint();
        if(DrawShape.type == DrawShape.OTHER) {
            dot.addPoint(Start.x, Start.y, Stop.x, Stop.y);
            Start = Stop;
        }
            /**
             * 这里repaint的时候会调用到上面的paintComponent方法。
             */
            e.getComponent().repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        dottedTag = true;
        Start = e.getPoint();
        Stop = Start;
        if(DrawShape.type == DrawShape.OTHER) {
            dot = new Dot();
            color = ColorHandler.color;
            dot.setColorWidth(color, width);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        dottedTag = false;
        if(DrawShape.type == DrawShape.OTHER) {
            DrawShape.shapes.add(dot);
            count++;
        }

        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Point p = e.getPoint();
        JTextField textField = new JTextField("输入类型");
        textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setEditable(false);
                }
            });
        textField.setBounds(p.x-35, p.y-10, 70, 20);
        this.add(textField);
        repaint();

    }

    public Vector<shape.Shape> getShapes() {
        return DrawShape.shapes;
    }

    public void checkShape() {
        JLabel label = new JLabel();
        if (count == 1) {
            label.setText("圆形");
        } else if(count == 3) {
            label.setText("三角形");
        } else if (count == 4) {
            label.setText("矩形");
        }
        label.setBounds(dot.getStopPoint().x, dot.getStopPoint().y, 45, 20);
        this.add(label);
        repaint();

    }

    public void countClear() {
        this.count = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
