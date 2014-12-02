//GuiFrame.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiFrame extends JFrame implements ActionListener{
	
	Container cPane;
	JMenu fileMenu;
	JMenuBar menuBar;
	
	public void getGuiFrame()
	{
		
		setLocation(250,200);
		setSize(750,480);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		cPane = getContentPane();
		cPane.setLayout(null);
		cPane.setBackground(new Color(51,102,255));
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		createFileMenuItem();
		menuBar.add(fileMenu);
	}
	
	public void createFileMenuItem()
	{
		fileMenu = new JMenu("File");
		
		JMenuItem menuItem;
		
		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);	
		
		menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String menu = e.getActionCommand();
		if(menu.equals("Open"))
		{
			SecondMainPage secondPage = new SecondMainPage();
			setVisible(false);
		}
		else if(menu.equals("Quit"))
		{
			FunctionList function = new FunctionList();
			function.exit();
		}
		
	}
	
	
}