package simple.menu.menuitem.command;

import simple.menu.menuitem.command.data.MenuItemCommandData;

public class QuitCommand implements MenuItemCommand {

    @Override
    public void execute(MenuItemCommandData commandData) {
        System.exit(0);
    }

}
