package fileControl;

import gui.DrawShape;
import shape.Shape;
import shape.Tag;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSaver {
    FileWriter fileWriter;
    PrintWriter printWriter;
    JFileChooser jFileChooser;
    public static boolean isSaved = true;

    public FileSaver() {
        jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("src"));
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("txt", "txt");
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        jFileChooser.showSaveDialog(null);

        try {

            fileWriter = new FileWriter(jFileChooser.getSelectedFile());
            printWriter = new PrintWriter(fileWriter);
            for(Shape s : DrawShape.shapes){
                s.output(printWriter);
            }

            for(Tag t : DrawShape.tags) {
                t.output(printWriter);
            }
            printWriter.close();
            fileWriter.close();
            isSaved = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
