package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("New")) {
            Tools.New();
        } else if (e.getActionCommand().equals("Undo")) {
            Tools.Revoke();
        } else if (e.getActionCommand().equals("Save")) {
            
        }
    }
}
