package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class LineWidthPanel extends JPanel {
    public static int width = 1;

    JSlider jSlider;
    JTextField jTextField;
    JPanel jPanel_data;

    public LineWidthPanel() {
        super(new GridLayout(2, 1));

        setBorder(new TitledBorder("LineWidth"));
        setPreferredSize(new Dimension(190, 140));
        setBackground(Color.getHSBColor(164, 194, 244));

        jSlider = new JSlider();
        jPanel_data = new JPanel();
        jTextField = new JTextField();

        jPanel_data.setLayout(new GridLayout(1, 2));
        jPanel_data.add(jSlider);
        jPanel_data.add(jTextField);

        add(jPanel_data);

        jSlider.setMaximum(100);
        jSlider.setMinimum(width);
        jSlider.setValue(width);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                width = jSlider.getValue() / 3;
                jTextField.setText("" + (width * 3 + 1));
                repaint();
                DragDrawPanel.width = width;
            }
        });

        jTextField.setText("" + width);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(width));
        graphics2D.setColor(ColorHandler.color);
        graphics2D.drawLine(20, 110, 170, 110);
        graphics2D.setStroke(new BasicStroke());
    }
}
