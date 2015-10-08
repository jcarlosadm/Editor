package menu.menuitem.factory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PasteMenuItemFactory extends MenuItemFactory {

    private static final String NAME = "Paste";
    private static final char MNEMONIC = 'P';
    private static final int SHORTCUT_KEY = KeyEvent.VK_V;
    private static final int SHORTCUT_MOD_KEY = InputEvent.CTRL_DOWN_MASK;

    public PasteMenuItemFactory() {
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
