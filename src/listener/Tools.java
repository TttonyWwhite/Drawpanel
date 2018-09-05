package listener;

import fileControl.FileSaver;
import gui.DrawShape;

import javax.swing.*;

public class Tools {
    public static final int EXIT = 1;
    public static final int OPEN = 2;
    public static final int NEW = 3;

    public static int type = 0;

    private static void Jnew() {
        DrawShape.shapes.clear();
        DrawShape.pnlDisplayArea.repaint();
    }

    public static int windowExit() {
        //todo 保存
        System.exit(0);

        return 0;
    }

    public static void New() {
        Jnew();
    }

    public static void Save() {
        FileSaver fileSaver = new FileSaver();
    }

    /**
     * 撤销
     */
    public static void Revoke() {
        if(!DrawShape.shapes.isEmpty()) {
            DrawShape.shapes.removeElementAt(DrawShape.shapes.size() - 1);
            DrawShape.pnlDisplayArea.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Null shapes");
        }
    }

    public static void Clear() {
        DrawShape.shapes.clear();
        DrawShape.pnlDisplayArea.repaint();
    }

}


