package menu.menuitem.command;

import simple.editor.FindDialog;
import menu.menuitem.command.data.MenuItemCommandData;

public class FindCommand implements MenuItemCommand {

    @Override
    public void execute(MenuItemCommandData commandData) {
        FindDialog find = new FindDialog(commandData.getEditor(), true);
        find.showDialog();
    }

}
