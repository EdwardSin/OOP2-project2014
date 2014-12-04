//BankSystem.java

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BankSystem extends GuiFrame{
	
	JMenu fileMenu;
	JButton showAccountBalanceButton;
	JButton withdrawButton;
	JButton lodgeButton;
	JButton exitButton;
	int numberClicked=0;
	GuiFrame gui;
	
	public BankSystem(){
		
			gui = new GuiFrame();				//create an instant to use the guiFrame
			gui.getGuiFrame();
			gui.setTitle("Bank System");
			
			JLabel label = new JLabel("Welcome!");		//create a welcome label
			gui.cPane.add(label);
			label.setBounds(300,25,300,100);			//set the style of label
			label.setFont(new Font("Courier New", Font.PLAIN,40));
		
			FunctionButtonHandler handler = new FunctionButtonHandler();	//create a listener
			
			showAccountBalanceButton = new JButton("Balance");		//create a button
			showAccountBalanceButton.addActionListener(handler);		//add a handler
			showAccountBalanceButton.setBounds(230,130,300,50);			//set style of button
			showAccountBalanceButton.setFont(new Font("Courier New", Font.PLAIN,20));
			
			withdrawButton = new JButton("Withdraw");				//create a withdraw button
			withdrawButton.addActionListener(handler);
			withdrawButton.setBounds(230,210,300,50);				//set the style of withdraw button
			withdrawButton.setFont(new Font("Courier New", Font.PLAIN,20));
		
			lodgeButton = new JButton("Lodge");						//create a lodge button
			lodgeButton.addActionListener(handler);
			lodgeButton.setBounds(230,290,300,50);					//set the style of lodge button
			lodgeButton.setFont(new Font("Courier New", Font.PLAIN,20));
		
			gui.cPane.add(showAccountBalanceButton);
			gui.cPane.add(withdrawButton);
			gui.cPane.add(lodgeButton);
			
			exitButton = new JButton("Exit");						//create an exit button
			exitButton.setBounds(600,25,110,50);					//set the style of exit button
			exitButton.setFont(new Font("Courier New", Font.PLAIN,16));
			exitButton.addActionListener(handler);					//add a listener to exit button
			gui.cPane.add(exitButton);
			
			gui.setVisible(true);	
	}
	
	private class FunctionButtonHandler implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == withdrawButton)
		{
			try{		
					FunctionList function = new FunctionList();		//use the withdrawMoney method in the FunctionList
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
					FunctionList function = new FunctionList();		//use the lodgeMoney method in the FunctionList
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
					FunctionList function = new FunctionList();		//use the show account balance method in the FunctionList
					function.showAccountBalance();
					gui.setVisible(false);
			}
			catch(Exception exception){
				JOptionPane.showMessageDialog(null,"Error occurs");
			}
		}
		else if(e.getSource() == exitButton)
		{
			FunctionList function = new FunctionList();			//use the exit method in FunctionList
			function.exit();
		}
	}
	}
}