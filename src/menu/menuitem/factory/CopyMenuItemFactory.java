package menu.menuitem.factory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import menu.menuitem.command.CopyCommand;
import menu.menuitem.command.MenuItemCommand;

public class CopyMenuItemFactory extends MenuItemFactory {

    private static final String NAME = "Copy";
    private static final char MNEMONIC = 'C';
    private static final int SHORTCUT_KEY = KeyEvent.VK_C;
    private static final int SHORTCUT_MOD_KEY = InputEvent.CTRL_DOWN_MASK;
    
    private static final MenuItemCommand COMMAND = new CopyCommand();

    public CopyMenuItemFactory() {
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
