package menu.factory;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import menu.menuitem.factory.NewMenuItemFactory;
import menu.menuitem.factory.OpenMenuItemFactory;
import menu.menuitem.factory.QuitMenuItemFactory;
import menu.menuitem.factory.SaveAsMenuItemFactory;
import menu.menuitem.factory.SaveMenuItemFactory;
import simple.editor.Editor;

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
    protected List<JMenuItem> getMenuItens(Editor editor) {
        
        List<JMenuItem> itens = new ArrayList<JMenuItem>();
        
        itens.add((new NewMenuItemFactory()).getMenuItem(editor));
        itens.add((new OpenMenuItemFactory()).getMenuItem(editor));
        itens.add((new SaveMenuItemFactory()).getMenuItem(editor));
        itens.add((new SaveAsMenuItemFactory()).getMenuItem(editor));
        itens.add((new QuitMenuItemFactory()).getMenuItem(editor));
        
        return itens;
    }

}
