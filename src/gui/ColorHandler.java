package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorHandler extends JPanel {
    JColorChooser jColorChooser;
    JButton button;
    Color tempColor;

    public static Color color = new Color(0, 0 ,0);

    JPanel jPanel;

    public ColorHandler() {
        super(new GridLayout(2, 1));
        jPanel = new JPanel();
        color = new Color(0, 0, 0);
        setBorder(new TitledBorder("Color"));
        jPanel.setBackground(color);
        setPreferredSize(new Dimension(190, 140));
        setBackground(Color.white);
        button = new JButton();
        jColorChooser = new JColorChooser();
        button.setText("Open the color manager");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempColor = JColorChooser.showDialog(new JFrame(), "ColorChooser", color.BLACK);
                if(tempColor != null) {
                    color = tempColor;
                    DrawShape.lineWidthPanel.repaint();
                }
            }
        });

        add(button);
        add(jPanel);
    }
}
