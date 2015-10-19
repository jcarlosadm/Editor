package simple.menu.menuitem.command;

import simple.editor.FindDialog;
import simple.menu.menuitem.command.data.MenuItemCommandData;

public class FindCommand implements MenuItemCommand {

    @Override
    public void execute(MenuItemCommandData commandData) {
        FindDialog find = new FindDialog(commandData.getEditor(), true);
        find.showDialog();
    }

}
