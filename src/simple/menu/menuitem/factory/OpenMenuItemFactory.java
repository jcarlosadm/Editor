package simple.menu.menuitem.factory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import simple.menu.menuitem.command.MenuItemCommand;
import simple.menu.menuitem.command.OpenCommand;

public class OpenMenuItemFactory extends MenuItemFactory {

    private static final String NAME = "Open";
    private static final char MNEMONIC = 'O';
    private static final int SHORTCUT_KEY = KeyEvent.VK_O;
    private static final int SHORTCUT_MOD_KEY = InputEvent.CTRL_DOWN_MASK;
    
    private static final MenuItemCommand COMMAND = new OpenCommand();

    public OpenMenuItemFactory() {
    }

    @Override
    protected int getShortcutModkey() {
        return SHORTCUT_MOD_KEY;
    }

    @Override
    protected int getShortcutKey() {
        return SHORTCUT_KEY;
    }

    @Override
    protected char getMnemonic() {
        return MNEMONIC;
    }

    @Override
    protected String getName() {
        return NAME;
    }

    @Override
    protected boolean hasMnemonic() {
        return true;
    }

    @Override
    protected MenuItemCommand getCommand() {
        return COMMAND;
    }

}
