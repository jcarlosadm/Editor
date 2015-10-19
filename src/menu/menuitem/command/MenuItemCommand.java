package menu.menuitem.command;

import menu.menuitem.command.data.MenuItemCommandData;

public interface MenuItemCommand {
    public void execute(MenuItemCommandData commandData);
}
