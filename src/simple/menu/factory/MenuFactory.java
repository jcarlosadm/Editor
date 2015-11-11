package simple.menu.factory;

import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import simple.editor.Editor;
import simple.menu.MenuType;

/**
 * MenuFactory
 * TODO Abstract factory pattern
 */
public abstract class MenuFactory {

    protected MenuFactory() {}
    
    /**
     * TODO factory method pattern
     * @param menuType
     * @return get MenuFactory instance
     */
    public static MenuFactory getMenuFactory(MenuType menuType){
        
        if (menuType.equals(MenuType.FILE)) {
            return new FileMenuFactory();
        }
        else if (menuType.equals(MenuType.EDIT)) {
            return new EditMenufactory();
        }
        
        return null;
    }
    
    public JMenu getMenu(Editor editor){
        JMenu jMenu = this.getJMenuInstance();
        
        List<JMenuItem> menuItems = this.getMenuItens(editor);
        for (JMenuItem jMenuItem : menuItems) {
            jMenu.add(jMenuItem);
        }
        
        return jMenu;
    }
    
    protected abstract JMenu getJMenuInstance();

    protected abstract List<JMenuItem> getMenuItens(Editor editor);
    
    

}
