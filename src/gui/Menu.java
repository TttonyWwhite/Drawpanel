package gui;

import listener.MyMenuListener;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar{

    JMenu jMenu_File;
    JMenu jMenu_Edit;

    JMenuItem jMenuItem_new;
    JMenuItem jMenuItem_save;
    JMenuItem jMenuItem_undo;

    public Menu() {
        jMenu_File = new JMenu("File");
        jMenu_File.setMnemonic(KeyEvent.VK_F);

        jMenu_Edit = new JMenu("Edit");
        jMenu_Edit.setMnemonic(KeyEvent.VK_E);

        jMenuItem_new = new JMenuItem("New");
        jMenuItem_save = new JMenuItem("Save");
        jMenuItem_undo = new JMenuItem("Undo");

        add(jMenu_File);
        add(jMenu_Edit);

        jMenu_File.add(jMenuItem_new);
        jMenu_File.add(jMenuItem_save);

        jMenu_Edit.add(jMenuItem_undo);

        jMenuItem_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        jMenuItem_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        jMenuItem_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));

        MyMenuListener menuListener = new MyMenuListener();
        jMenuItem_new.addActionListener(menuListener);
        jMenuItem_save.addActionListener(menuListener);
        jMenuItem_undo.addActionListener(menuListener);
    }
}
