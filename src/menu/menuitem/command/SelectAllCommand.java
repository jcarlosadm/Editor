package menu.menuitem.command;

import simple.editor.Editor;
import menu.menuitem.command.data.MenuItemCommandData;

public class SelectAllCommand implements MenuItemCommand {

    @Override
    public void execute(MenuItemCommandData commandData) {
        Editor editor = commandData.getEditor();
        editor.getTextPane().selectAll();
    }

}
