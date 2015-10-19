package simple.menu.menuitem.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import simple.editor.Editor;
import simple.menu.menuitem.command.data.MenuItemCommandData;

public class OpenCommand implements MenuItemCommand {

    private static final String ERROR_TITLE = "Error";
    private static final String ERROR_MESSAGE = "Cannot read file !";

    @Override
    public void execute(MenuItemCommandData commandData) {
        Editor editor = commandData.getEditor();
        
        JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
        dialog.setMultiSelectionEnabled(false);
        
        try {
            int result = dialog.showOpenDialog(editor);
            if (result == JFileChooser.CANCEL_OPTION)
                return;
            if (result == JFileChooser.APPROVE_OPTION) {
                if (editor.isChanged() == true)
                    editor.executeSave();
                File file = dialog.getSelectedFile();
                editor.setFile(file);
                editor.getTextPane().setText(this.readFile(file));
                editor.setChanged(false);
                editor.setTitle("Editor - " + file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String readFile(File file) {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = null;
        try {
            FileReader fr = new FileReader(file);       
            reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line + "\n");
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR_MESSAGE, ERROR_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return result.toString();
    }

}
