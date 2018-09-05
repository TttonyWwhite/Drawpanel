package gui;


import listener.WindowCloseListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class DrawShape extends JFrame {

    JPanel pnlCommandArea = new JPanel(new FlowLayout());
    public static DragDrawPanel pnlDisplayArea = new DragDrawPanel();
    JPanel pnlShape = new JPanel(new GridLayout(1, 1));
    JPanel pnlFile = new JPanel(new GridLayout(2, 2));

    public static LineWidthPanel lineWidthPanel = new LineWidthPanel();
    public static ColorHandler colorHandler = new ColorHandler();
    Menu menu = new Menu();

    //static JButton openBtn = new JButton("Open");
    static JButton newBtn = new JButton("New");
    static JButton editBtn = new JButton("Edit");

    public static JButton checkBtn = new JButton("识别图形");

    public static Vector<shape.Shape> shapes = new Vector<>();

    ButtonGroup shapeGroup = new ButtonGroup();
    ButtonGroup drawGroup = new ButtonGroup();

    Container contentPanel;

    /**
     * 用常数表示图的类型
     */
    public final static int OTHER = 0;
    public final static int CHECK = 1;

    public static int type = OTHER;

    public DrawShape() {
        setTitle("画板");
        setSize(850, 680);
        setLayout(new FlowLayout());
        pnlCommandArea.setBorder(new TitledBorder("Command Area"));
        pnlCommandArea.setPreferredSize(new Dimension(200, 600));
        pnlCommandArea.setLayout(new GridLayout(4, 1));

        shapes = pnlDisplayArea.getShapes();

        setJMenuBar(menu);
        add(pnlCommandArea);
        add(pnlDisplayArea);


        pnlShape.setPreferredSize(new Dimension(200, 140));
        pnlShape.setBackground(Color.WHITE);
        pnlShape.setBorder(new TitledBorder("Shape"));

        pnlCommandArea.add(pnlShape);
        pnlCommandArea.add(lineWidthPanel);
        pnlCommandArea.add(colorHandler);


        pnlShape.add(checkBtn, 0);


        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlDisplayArea.checkShape();
                pnlDisplayArea.countClear();
            }
        });


        //添加按钮快捷键
        newBtn.setMnemonic(KeyEvent.VK_N);
        editBtn.setMnemonic(KeyEvent.VK_E);

        //添加按钮监听器


        pnlFile.add(newBtn, 0);

        WindowCloseListener windowCloseListener = new WindowCloseListener();
        addWindowListener(windowCloseListener);
        setVisible(true);
    }
}
