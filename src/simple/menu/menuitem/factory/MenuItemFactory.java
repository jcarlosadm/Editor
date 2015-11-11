package simple.menu.menuitem.factory;

import javax.swing.KeyStroke;

import simple.editor.Editor;
import simple.menu.menuitem.MenuItem;
import simple.menu.menuitem.command.MenuItemCommand;

/**
 * MenuItemFactory
 * TODO Abstract factory pattern
 */
public abstract class MenuItemFactory {

    public MenuItemFactory() {
    }

    public MenuItem getMenuItem(Editor parent) {
        
        MenuItem menuItem = new MenuItem(this.getName());

        menuItem.setName(this.getName());
        
        if (this.hasMnemonic()) {
            menuItem.setMnemonic(this.getMnemonic());
        }

        menuItem.setAccelerator(KeyStroke.getKeyStroke(this.getShortcutKey(),
                this.getShortcutModkey()));
        
        menuItem.addActionListener(menuItem);
        
        menuItem.setParent(parent);
        menuItem.setCommand(this.getCommand());

        return menuItem;
    }

    protected abstract int getShortcutModkey();

    protected abstract int getShortcutKey();

    protected abstract char getMnemonic();

    protected abstract String getName();
    
    protected abstract boolean hasMnemonic();
    
    protected abstract MenuItemCommand getCommand();
}
