package menu.menuitem.command;

import menu.menuitem.command.data.MenuItemCommandData;

public class QuitCommand implements MenuItemCommand {

    @Override
    public void execute(MenuItemCommandData commandData) {
        System.exit(0);
    }

}
