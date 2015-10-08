package menu.menuitem.factory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SaveAsMenuItemFactory extends MenuItemFactory {

    private static final String NAME = "Save as...";
    private static final int SHORTCUT_KEY = KeyEvent.VK_S;
    private static final int SHORTCUT_MOD_KEY = InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK;

    public SaveAsMenuItemFactory() {
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
        return 0;
    }

    @Override
    protected String getName() {
        return NAME;
    }

    @Override
    protected boolean hasMnemonic() {
        return false;
    }

}
