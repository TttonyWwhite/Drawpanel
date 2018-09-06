package controller;

import gui.DrawShape;
import shape.Dot;
import shape.Tag;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOpener {
    FileReader fileReader;
    JFileChooser jFileChooser;

    public FileOpener() {
        jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("src"));
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("txt", "txt");
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        jFileChooser.showOpenDialog(null);

        DrawShape.shapes.clear();

        try {
            fileReader = new FileReader(jFileChooser.getSelectedFile());
            while(fileReader.ready()) {
                switch (fileReader.read()) {
                    case 'D':
                        Dot dot = new Dot(fileReader);
                        int a = 'G';
                        fileReader.read();
                        fileReader.read();
                        while (a == fileReader.read()) {
                            dot.readmore(fileReader);
                            fileReader.read();
                            fileReader.read();
                        }
                        DrawShape.shapes.add(dot);
                        break;
                    case 'T':
                        Tag tag = new Tag(fileReader);
                        DrawShape.tags.add(tag);
                        break;
                }
            }
            fileReader.close();
            JOptionPane.showMessageDialog(null, "Open Success", "Message", 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
