package simple.editor;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import simple.menu.MenuType;
import simple.menu.factory.MenuFactory;
import simple.menu.menuitem.command.MenuItemCommand;
import simple.menu.menuitem.command.SaveAsCommand;
import simple.menu.menuitem.command.SaveCommand;
import simple.menu.menuitem.command.data.MenuItemCommandData;

@SuppressWarnings("serial")
public class Editor extends JFrame implements DocumentListener {

    private JEditorPane textPane;
    private boolean changed = false;
    private File file;

    private MenuItemCommand saveCommand = new SaveCommand();
    private MenuItemCommand saveAsCommand = new SaveAsCommand();

    private static Editor instance = null;

    private Editor() {
        super("Editor");
        this.textPane = new JEditorPane();
        this.add(new JScrollPane(this.textPane), BorderLayout.CENTER);
        this.textPane.getDocument().addDocumentListener(this);

        this.createMenuBar();

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * TODO Singleton pattern
     * @return editor instance
     */
    public static synchronized Editor getEditor() {
        if (instance == null) {
            instance = new Editor();
        }

        return instance;
    }

    private void createMenuBar() {
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        menu.add(MenuFactory.getMenuFactory(MenuType.FILE).getMenu(this));
        menu.add(MenuFactory.getMenuFactory(MenuType.EDIT).getMenu(this));
    }

    public void executeSave() {
        MenuItemCommandData data = new MenuItemCommandData();
        data.setEditor(this);
        this.saveCommand.execute(data);
    }

    public void executeSaveAs(String dialogTitle) {
        MenuItemCommandData data = new MenuItemCommandData();
        data.setEditor(this);
        data.setDialogTitle(dialogTitle);
        this.saveAsCommand.execute(data);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.changed = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.changed = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.changed = true;
    }

    public JEditorPane getTextPane() {
        return this.textPane;
    }

    public boolean isChanged() {
        return this.changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void run() {
        this.setVisible(true);
    }

}
