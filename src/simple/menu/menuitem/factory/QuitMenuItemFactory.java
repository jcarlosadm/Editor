package simple.menu.menuitem.factory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import simple.menu.menuitem.command.MenuItemCommand;
import simple.menu.menuitem.command.QuitCommand;

public class QuitMenuItemFactory extends MenuItemFactory {

    private static final String NAME = "Quit";
    private static final char MNEMONIC = 'Q';
    private static final int SHORTCUT_KEY = KeyEvent.VK_Q;
    private static final int SHORTCUT_MOD_KEY = InputEvent.CTRL_DOWN_MASK;
    
    private static final MenuItemCommand COMMAND = new QuitCommand();

    public QuitMenuItemFactory() {
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
