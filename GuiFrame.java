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
		
		setLocation(250,200);							//set the style of gui
		setSize(750,480);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		cPane = getContentPane();
		cPane.setLayout(null);
		cPane.setBackground(new Color(51,102,255));
		
		
		JMenuBar menuBar = new JMenuBar();				//create a menuBar
		setJMenuBar(menuBar);							//set the gui menubar
		
		
		createFileMenuItem();
		menuBar.add(fileMenu);							//add the menu to menuBar
	}
	
	public void createFileMenuItem()
	{
		fileMenu = new JMenu("File");					//create a file menu
		
		JMenuItem menuItem;
		
		menuItem = new JMenuItem("Open");				//create a menuitem called "Open"
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);							//add the menuitem to menu
		
		menuItem = new JMenuItem("Quit");				//create a menuitem called "Open"	
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);							//add the menuitem to menu
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String menu = e.getActionCommand();
		if(menu.equals("Open"))								//function when the user click on the menu item called "Open"
		{
			SecondMainPage secondPage = new SecondMainPage();
			setVisible(false);
		}
		else if(menu.equals("Quit"))								//function when the user click on the menu item called "Quit"
		{
			FunctionList function = new FunctionList();
			function.exit();
		}
		
	}
	
	
}