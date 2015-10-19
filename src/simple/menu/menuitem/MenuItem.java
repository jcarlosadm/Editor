package simple.menu.menuitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import simple.editor.Editor;
import simple.menu.menuitem.command.MenuItemCommand;
import simple.menu.menuitem.command.data.MenuItemCommandData;

@SuppressWarnings("serial")
public class MenuItem extends JMenuItem implements ActionListener {

    private Editor parent = null;
    
    private MenuItemCommand command = null;
    
    public MenuItem(String text) {
        super(text);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.parent != null && this.command != null) {
            MenuItemCommandData commandData = new MenuItemCommandData();
            commandData.setEditor(this.parent);
            this.command.execute(commandData);
        }
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Editor parent) {
        this.parent = parent;
    }
    
    /**
     * @param command the command to set 
     */
    public void setCommand(MenuItemCommand command){
        this.command = command;
    }

}
