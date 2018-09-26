package listener;

import controller.Tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New":
                Tools.New();
                break;
            case "Undo":
                Tools.Revoke();
                break;
            case "Save":
                Tools.Save();
                break;
            case "Open":
                Tools.Open();
                break;
        }
    }
}
