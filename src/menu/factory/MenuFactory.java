package menu.factory;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import menu.MenuType;

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
    
    public JMenu getMenu(ActionListener listener){
        JMenu jMenu = this.getJMenuInstance();
        
        List<JMenuItem> menuItems = this.getMenuItens(listener);
        for (JMenuItem jMenuItem : menuItems) {
            jMenu.add(jMenuItem);
        }
        
        return jMenu;
    }
    
    protected abstract JMenu getJMenuInstance();

    protected abstract List<JMenuItem> getMenuItens(ActionListener listener);
    
    

}
