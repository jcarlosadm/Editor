package menu.menuitem.command;

import menu.menuitem.command.data.MenuItemCommandData;
import simple.editor.Editor;

public class NewCommand implements MenuItemCommand {

    private static final String EDITOR_TITLE = "Editor";

    @Override
    public void execute(MenuItemCommandData commandData) {
        Editor editor = commandData.getEditor();
        
        if (editor.isChanged())
            editor.executeSave();
        editor.setFile(null);
        editor.getTextPane().setText("");
        editor.setChanged(false);
        editor.setTitle(EDITOR_TITLE);
    }

}
