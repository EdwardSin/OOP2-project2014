
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
	
public class MainPage extends GuiFrame implements ActionListener{
	JButton startButton;
	GuiFrame gui;
	
	public MainPage()
	{
		gui = new GuiFrame();
		gui.getGuiFrame();
		
		JLabel label = new JLabel("Welcome to AIB Bank");
		
		gui.setTitle("Bank System");
		
		gui.cPane.add(label);
		label.setBounds(100,100,700,100);
		label.setFont(new Font("Courier New", Font.PLAIN,50));
		gui.setVisible(true);
		
		startButton = new JButton("Start");
		startButton.setBounds(270,210,200,100);
		startButton.setFont(new Font("Courier New", Font.PLAIN,30));
		startButton.addActionListener(this);
		gui.cPane.add(startButton);
		
	}
	
	public static void main(String args[])
	{
	
		MainPage mainPage = new MainPage();
		
		
	}
	
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == startButton)
			{
				SecondMainPage sMainP = new SecondMainPage();
				gui.setVisible(false);
			}
		}
	
}