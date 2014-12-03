//BankSystem.java

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BankSystem extends GuiFrame{
	
	JMenu fileMenu;
	JButton showAccountDetailButton;
	JButton withdrawButton;
	JButton lodgeButton;
	JButton showAccountBalanceButton;
	JButton exitButton;
	int numberClicked=0;
	GuiFrame gui;
	
	public BankSystem(){
		
			gui = new GuiFrame();
			gui.getGuiFrame();
			gui.setTitle("Bank System");
			
			JLabel label = new JLabel("Welcome!");
			gui.cPane.add(label);
			label.setBounds(300,25,300,100);
			label.setFont(new Font("Courier New", Font.PLAIN,40));
		
			FunctionButtonHandler handler = new FunctionButtonHandler();
			
			showAccountBalanceButton = new JButton("Balance");
			showAccountBalanceButton.addActionListener(handler);
			showAccountBalanceButton.setBounds(230,130,300,50);
			showAccountBalanceButton.setFont(new Font("Courier New", Font.PLAIN,20));
			
			withdrawButton = new JButton("Withdraw");
			withdrawButton.addActionListener(handler);
			withdrawButton.setBounds(230,210,300,50);
			withdrawButton.setFont(new Font("Courier New", Font.PLAIN,20));
		
			lodgeButton = new JButton("Lodge");
			lodgeButton.addActionListener(handler);
			lodgeButton.setBounds(230,290,300,50);
			lodgeButton.setFont(new Font("Courier New", Font.PLAIN,20));
		
			gui.cPane.add(showAccountBalanceButton);
			gui.cPane.add(withdrawButton);
			gui.cPane.add(lodgeButton);
			
			exitButton = new JButton("Exit");
			exitButton.setBounds(600,25,110,50);
			exitButton.setFont(new Font("Courier New", Font.PLAIN,16));
			exitButton.addActionListener(handler);
			gui.cPane.add(exitButton);
			
			gui.setVisible(true);	
	}
	
	private class FunctionButtonHandler implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == withdrawButton)
		{
			try{		
					FunctionList function = new FunctionList();
					function.withdrawMoney();
					gui.setVisible(false);
			}
			catch(Exception exception){
				JOptionPane.showMessageDialog(null,"Error occurs");
			}
		}
		else if(e.getSource() == lodgeButton)
		{
			try{
					FunctionList function = new FunctionList();
					function.lodgeMoney();
					gui.setVisible(false);
			}
			catch(Exception exception){
				JOptionPane.showMessageDialog(null,"Error occurs");
			}
		}
		else if(e.getSource() == showAccountBalanceButton)
		{
			try{
					FunctionList function = new FunctionList();
					function.showAccountBalance();
					gui.setVisible(false);
			}
			catch(Exception exception){
				JOptionPane.showMessageDialog(null,"Error occurs");
			}
		}
		else if(e.getSource() == exitButton)
		{
			FunctionList function = new FunctionList();
			function.exit();
		}
	}
	}
	public static void main(String args[])
	{
		BankSystem bb = new BankSystem();
	}	
}