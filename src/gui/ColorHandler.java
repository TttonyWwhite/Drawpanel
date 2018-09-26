package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ColorHandler extends JPanel {
    private Color tempColor;

    public static Color color = new Color(0, 0 ,0);

    ColorHandler() {
        super(new GridLayout(2, 1));
        JPanel jPanel = new JPanel();
        JButton button = new JButton();

        color = new Color(0, 0, 0);
        setBorder(new TitledBorder("Color"));
        jPanel.setBackground(color);
        setPreferredSize(new Dimension(190, 140));
        setBackground(Color.white);

        JColorChooser jColorChooser = new JColorChooser();
        button.setText("Open the color manager");
        button.addActionListener(e -> {
            tempColor = JColorChooser.showDialog(new JFrame(), "ColorChooser", Color.BLACK);
            if(tempColor != null) {
                color = tempColor;
                DrawShape.lineWidthPanel.repaint();
            }
        });

        add(button);
        add(jPanel);
    }
}
