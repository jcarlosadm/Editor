package menu.menuitem.command;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import menu.menuitem.command.data.MenuItemCommandData;
import simple.editor.Editor;

public class SaveAsCommand implements MenuItemCommand {

    private static final String SAVEAS_DIALOG_TITLE = "Save as...";

    @Override
    public void execute(MenuItemCommandData commandData) {
        Editor editor = commandData.getEditor();
        
        if (commandData.getDialogTitle() == "") {
            commandData.setDialogTitle(SAVEAS_DIALOG_TITLE);
        }
        
        JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
        dialog.setDialogTitle(commandData.getDialogTitle());
        
        int result = dialog.showSaveDialog(editor);
        if (result != JFileChooser.APPROVE_OPTION)
            return;
        
        editor.setFile(dialog.getSelectedFile());
        
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(editor.getFile());
            writer.write(editor.getTextPane().getText());
            editor.setChanged(false);
            editor.setTitle("Editor - " + editor.getFile().getName());
            
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
