package menu.factory;

import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import menu.MenuType;
import simple.editor.Editor;

public abstract class MenuFactory {

    protected MenuFactory() {}
    
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
