package simple.menu.menuitem.command;

import simple.menu.menuitem.command.data.MenuItemCommandData;

/**
 * MenuItemCommand
 * TODO Command pattern
 */
public interface MenuItemCommand {
    public void execute(MenuItemCommandData commandData);
}
