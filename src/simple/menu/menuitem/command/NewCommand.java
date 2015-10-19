package simple.menu.menuitem.command;

import simple.editor.Editor;
import simple.menu.menuitem.command.data.MenuItemCommandData;

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
