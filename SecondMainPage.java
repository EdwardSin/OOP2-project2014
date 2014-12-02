import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SecondMainPage extends GuiFrame{
	
	JButton confirmButton;
	JButton exitButton;
	JTextField accountField;
	JPasswordField passwordField;
	int accountNumber;
	int accountPassword;
	GuiFrame gui; 
	
	public SecondMainPage(){
		
		gui= new GuiFrame();
		gui.getGuiFrame();
		
		gui.setTitle("Bank System");
	
		JLabel label = new JLabel("AIB Bank");
		
		gui.cPane.add(label);
		label.setBounds(275,25,300,100);
		label.setFont(new Font("Courier New", Font.PLAIN,40));
		
		JLabel accountLabel = new JLabel("Account: ");
		accountLabel.setBounds(175,150,140,100);
		accountLabel.setFont(new Font("Courier New", Font.PLAIN,25));
		gui.cPane.add(accountLabel);
		
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(175,190,160,100);
		passwordLabel.setFont(new Font("Courier New", Font.PLAIN,25));
		gui.cPane.add(passwordLabel);
		
		accountField = new JTextField(8);
		accountField.setBounds(340,185,250,30);
		accountField.setFont(new Font("Courier New", Font.PLAIN,30));
		gui.cPane.add(accountField);
		
		passwordField = new JPasswordField(8);
		passwordField.setBounds(340,220,250,30);
		passwordField.setFont(new Font("Courier New", Font.PLAIN,30));
		gui.cPane.add(passwordField);
		
		ButtonHandler handler = new ButtonHandler();
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(390,305,110,50);
		confirmButton.setFont(new Font("Courier New", Font.PLAIN,16));
		confirmButton.addActionListener(handler);
		gui.cPane.add(confirmButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(260,305,110,50);
		exitButton.setFont(new Font("Courier New", Font.PLAIN,16));
		exitButton.addActionListener(handler);
		gui.cPane.add(exitButton);
		
		gui.setVisible(true);
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == exitButton)
			{
				FunctionList function = new FunctionList();
				function.exit();
			}
			else if(e.getSource() == confirmButton)
			{
				
				try{
					accountNumber = Integer.parseInt(accountField.getText());
					accountPassword = Integer.parseInt(passwordField.getText());
				
				
					try{
						Scanner input = new Scanner(new File("accountDetails.txt"));
						int accInputNumber = input.nextInt();
						int accInputPassword = input.nextInt();
					
						if(accountNumber == accInputNumber && accountPassword == accInputPassword)
						{
							BankSystem bankSystem = new BankSystem();
							gui.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Please enter the correct acccount and password","Error",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					catch(IOException exception)
					{
							JOptionPane.showMessageDialog(null,"Retrieve Error","Error",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception NFexception){
					JOptionPane.showMessageDialog(null,"Please enter the correct acccount and password","Error",JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
			
			
		}
	}
}