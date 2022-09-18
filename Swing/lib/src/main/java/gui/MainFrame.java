package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		super("SwingApp");
		
		setSize(1000,800);
		setJMenuBar(createMenu());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		var fileMenu = new JMenu("File");
		var exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(e -> System.exit(0));
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		return menuBar;
	}

}
