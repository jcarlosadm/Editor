package menu.menuitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import menu.menuitem.command.MenuItemCommand;
import menu.menuitem.command.data.MenuItemCommandData;
import simple.editor.Editor;

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
