package simple.menu.menuitem.command.data;

import simple.editor.Editor;

public class MenuItemCommandData {
    
    private Editor editor = null;
    
    private String dialogTitle = "";

    /**
     * @return the editor
     */
    public Editor getEditor() {
        return this.editor;
    }

    /**
     * @param editor the editor to set
     */
    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    /**
     * @return the dialogTitle
     */
    public String getDialogTitle() {
        return this.dialogTitle;
    }

    /**
     * @param dialogTitle the dialogTitle to set
     */
    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }
    
}
