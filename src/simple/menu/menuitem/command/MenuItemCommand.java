package simple.menu.menuitem.command;

import simple.menu.menuitem.command.data.MenuItemCommandData;

public interface MenuItemCommand {
    public void execute(MenuItemCommandData commandData);
}
