
import java.awt.*;
import javax.swing.*;
	
public class MainPage extends GuiFrame{
	
	
	public static void main(String args[])
	{
		GuiFrame gui = new GuiFrame();
		gui.getGuiFrame();
		
		JLabel label = new JLabel("Welcome to AIB Bank");
		
		gui.setTitle("Bank System");
		
		gui.cPane.add(label);
		label.setBounds(100,100,700,100);
		label.setFont(new Font("Courier New", Font.PLAIN,50));
		gui.setVisible(true);
	}
	
}