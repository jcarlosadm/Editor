package menu.factory;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import menu.menuitem.factory.NewMenuItemFactory;
import menu.menuitem.factory.OpenMenuItemFactory;
import menu.menuitem.factory.QuitMenuItemFactory;
import menu.menuitem.factory.SaveAsMenuItemFactory;
import menu.menuitem.factory.SaveMenuItemFactory;

public class FileMenuFactory extends MenuFactory {

    private static final String NAME = "File";
    private static final char MNEMONIC = 'F';
    
    protected FileMenuFactory() {
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
        
        itens.add((new NewMenuItemFactory()).getMenuItem(listener));
        itens.add((new OpenMenuItemFactory()).getMenuItem(listener));
        itens.add((new SaveMenuItemFactory()).getMenuItem(listener));
        itens.add((new SaveAsMenuItemFactory()).getMenuItem(listener));
        itens.add((new QuitMenuItemFactory()).getMenuItem(listener));
        
        return itens;
    }

}
