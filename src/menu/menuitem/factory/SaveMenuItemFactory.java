package menu.menuitem.factory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SaveMenuItemFactory extends MenuItemFactory {

    private static final String NAME = "Save";
    private static final char MNEMONIC = 'S';
    private static final int SHORTCUT_KEY = KeyEvent.VK_S;
    private static final int SHORTCUT_MOD_KEY = InputEvent.CTRL_DOWN_MASK;

    public SaveMenuItemFactory() {
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
}
