package menu.menuitem.command;

import java.io.PrintWriter;

import javax.swing.JOptionPane;

import menu.menuitem.command.data.MenuItemCommandData;
import simple.editor.Editor;

public class SaveCommand implements MenuItemCommand {

    private static final String SAVE_DIALOG_TITLE = "Save file";
    private static final String SAVE_MESSAGE = "The file has changed. You want to save it?";
    
    private static final String SAVEAS_DIALOG_TITLE = "Save";
    
    private static final String WRITE_FILE_EXCEPTION_MESSAGE = "Cannot write file!";

    @Override
    public void execute(MenuItemCommandData commandData) {
        Editor editor = commandData.getEditor();
        
        if (editor.isChanged()) {
            int ans = JOptionPane.showConfirmDialog(null, SAVE_MESSAGE, SAVE_DIALOG_TITLE,
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (ans == JOptionPane.NO_OPTION)
                return;
        }
        
        if (editor.getFile() == null) {
            editor.executeSaveAs(SAVEAS_DIALOG_TITLE);
            return;
        }
        
        String text = editor.getTextPane().getText();
        System.out.println(text);
        
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(editor.getFile());
            if (!editor.getFile().canWrite())
                throw new Exception(WRITE_FILE_EXCEPTION_MESSAGE);
            writer.write(text);
            editor.setChanged(false);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            writer.close();
        }
    }

}
