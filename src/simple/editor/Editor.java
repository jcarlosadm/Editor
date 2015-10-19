package simple.editor;
import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import menu.MenuType;
import menu.factory.MenuFactory;
import menu.menuitem.command.MenuItemCommand;
import menu.menuitem.command.SaveAsCommand;
import menu.menuitem.command.SaveCommand;
import menu.menuitem.command.data.MenuItemCommandData;

@SuppressWarnings("serial")
public class Editor extends JFrame implements DocumentListener {

	private JEditorPane textPane;
	private boolean changed = false;
	private File file;
	
	private MenuItemCommand saveCommand = new SaveCommand();
	private MenuItemCommand saveAsCommand = new SaveAsCommand();

	public Editor() {
		super("Editor");
		textPane = new JEditorPane();
		add(new JScrollPane(textPane), BorderLayout.CENTER);
		textPane.getDocument().addDocumentListener(this);

		createMenuBar();

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    private void createMenuBar() {
        JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		menu.add(MenuFactory.getMenuFactory(MenuType.FILE).getMenu(this));
		menu.add(MenuFactory.getMenuFactory(MenuType.EDIT).getMenu(this));
    }
	
	public void executeSave(){
	    MenuItemCommandData data = new MenuItemCommandData();
	    data.setEditor(this);
	    this.saveCommand.execute(data);
	}
	
	public void executeSaveAs(String dialogTitle){
	    MenuItemCommandData data = new MenuItemCommandData();
        data.setEditor(this);
        data.setDialogTitle(dialogTitle);
        this.saveAsCommand.execute(data);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		changed = true;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		changed = true;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		changed = true;
	}
	
	public JEditorPane getTextPane(){
	    return this.textPane;
	}
	
	public boolean isChanged(){
	    return this.changed;
	}
	
	public void setChanged(boolean changed){
	    this.changed = changed;
	}
	
	public File getFile(){
	    return this.file;
	}
	
	public void setFile(File file){
	    this.file = file;
	}
	
	public static  void main(String[] args) {
        new Editor();
    }

}
