package simple.editor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import menu.MenuType;
import menu.factory.MenuFactory;

@SuppressWarnings("serial")
public class Editor extends JFrame implements ActionListener, DocumentListener {

	public static  void main(String[] args) {
		new Editor();
	}

	private JEditorPane textPane;
	private boolean changed = false;
	private File file;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Quit")) {
			System.exit(0);
		} else if (action.equals("Open")) {
			loadFile();
		} else if (action.equals("Save")) {
			saveFile();
		} else if (action.equals("New")) {
			newFile();
		} else if (action.equals("Save as...")) {
			saveAs("Save as...");
		} else if (action.equals("Select All")) {
			textPane.selectAll();
		} else if (action.equals("Copy")) {
			textPane.copy();
		} else if (action.equals("Cut")) {
			textPane.cut();
		} else if (action.equals("Paste")) {
			textPane.paste();
		} else if (action.equals("Find")) {
			FindDialog find = new FindDialog(this, true);
			find.showDialog();
		}
	}

	private void newFile() {
		if (changed)
			saveFile();
		file = null;
		textPane.setText("");
		changed = false;
		setTitle("Editor");
	}

	private void loadFile() {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
		dialog.setMultiSelectionEnabled(false);
		try {
			int result = dialog.showOpenDialog(this);
			if (result == JFileChooser.CANCEL_OPTION)
				return;
			if (result == JFileChooser.APPROVE_OPTION) {
				if (changed)
					saveFile();
				file = dialog.getSelectedFile();
				textPane.setText(readFile(file));
				changed = false;
				setTitle("Editor - " + file.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private String readFile(File file) {
		StringBuilder result = new StringBuilder();
		try (	FileReader fr = new FileReader(file);		
				BufferedReader reader = new BufferedReader(fr);) {
			String line;
			while ((line = reader.readLine()) != null) {
				result.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot read file !", "Error !", JOptionPane.ERROR_MESSAGE);
		}
		return result.toString();
	}

	private void saveFile() {
		if (changed) {
			int ans = JOptionPane.showConfirmDialog(null, "The file has changed. You want to save it?", "Save file",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (ans == JOptionPane.NO_OPTION)
				return;
		}
		if (file == null) {
			saveAs("Save");
			return;
		}
		String text = textPane.getText();
		System.out.println(text);
		try (PrintWriter writer = new PrintWriter(file);){
			if (!file.canWrite())
				throw new Exception("Cannot write file!");
			writer.write(text);
			changed = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveAs(String dialogTitle) {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
		dialog.setDialogTitle(dialogTitle);
		int result = dialog.showSaveDialog(this);
		if (result != JFileChooser.APPROVE_OPTION)
			return;
		file = dialog.getSelectedFile();
		try (PrintWriter writer = new PrintWriter(file);){
			writer.write(textPane.getText());
			changed = false;
			setTitle("Editor - " + file.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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

}
