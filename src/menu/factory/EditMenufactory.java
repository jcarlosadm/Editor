package menu.factory;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import menu.menuitem.factory.CopyMenuItemFactory;
import menu.menuitem.factory.CutMenuItemFactory;
import menu.menuitem.factory.FindMenuItemFactory;
import menu.menuitem.factory.PasteMenuItemFactory;
import menu.menuitem.factory.SelectAllMenuItemFactory;

public class EditMenufactory extends MenuFactory {

    private static final char MNEMONIC = 'E';
    private static final String NAME = "Edit";

    protected EditMenufactory() {
    }

    @Override
    protected JMenu getJMenuInstance() {
        JMenu jMenu = new JMenu(NAME);
        
        jMenu.setName(NAME);
        jMenu.setMnemonic(MNEMONIC);
        
        return jMenu;
    }

    @Override
    protected List<JMenuItem> getMenuItens(ActionListener listener) {
        List<JMenuItem> itens = new ArrayList<JMenuItem>();
        itens.add((new CutMenuItemFactory()).getMenuItem(listener));
        itens.add((new CopyMenuItemFactory()).getMenuItem(listener));
        itens.add((new PasteMenuItemFactory()).getMenuItem(listener));
        itens.add((new FindMenuItemFactory()).getMenuItem(listener));
        itens.add((new SelectAllMenuItemFactory()).getMenuItem(listener));
        
        return itens;
    }

}
