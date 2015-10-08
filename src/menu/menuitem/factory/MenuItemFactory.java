package menu.menuitem.factory;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public abstract class MenuItemFactory {

    public MenuItemFactory() {
    }

    public JMenuItem getMenuItem(ActionListener listener) {

        JMenuItem menuItem = new JMenuItem(this.getName());

        menuItem.setName(this.getName());
        
        if (this.hasMnemonic()) {
            menuItem.setMnemonic(this.getMnemonic());
        }

        menuItem.setAccelerator(KeyStroke.getKeyStroke(this.getShortcutKey(),
                this.getShortcutModkey()));

        menuItem.addActionListener(listener);

        return menuItem;
    }

    protected abstract int getShortcutModkey();

    protected abstract int getShortcutKey();

    protected abstract char getMnemonic();

    protected abstract String getName();
    
    protected abstract boolean hasMnemonic();
}
