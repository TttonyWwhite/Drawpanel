package listener;

import gui.DrawShape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckShapeListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "识别图形") {
            DrawShape.type = DrawShape.CHECK;
        }
    }
}
