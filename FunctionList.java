
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

public class FunctionList extends GuiFrame{
	
	JButton backButton;
	JButton exitButton;
	JButton confirmButton;
	JTextField amountField;
	GuiFrame gui;
	Account account = SecondMainPage.account;
	ArrayList<Account> accountList = SecondMainPage.accountList;
	int index = SecondMainPage.index;					//the position of the account in an array list
	
		public void showAccountBalance(){				//the show account balance gui
		gui = new GuiFrame();
		gui.getGuiFrame();
		gui.setTitle("Account Details");
		
		JLabel balanceMessage = new JLabel("Balance: " + String.format("%.2f",account.getAccountBalance()));		//create the balance label
		balanceMessage.setBounds(230,130,400,100);								//set the style of the balance label
		balanceMessage.setFont(new Font("Courier New", Font.PLAIN,20));
		gui.cPane.add(balanceMessage);											//add the label to cPane
		
		
		ShowAccountBalanceButtonHandler handler = new ShowAccountBalanceButtonHandler();			//create the handler
		
		backButton = new JButton("Back");									//create a back button
		backButton.setBounds(110,340,110,50);								//set the style of the back button
		backButton.setFont(new Font("Courier New", Font.PLAIN,16));
		backButton.addActionListener(handler);							//add the listener to the button
		gui.cPane.add(backButton);											//add the button to cPane
		
		exitButton = new JButton("Exit");								//create a exit button
		exitButton.setBounds(550,340,110,50);							//set the style of the exit button
		exitButton.setFont(new Font("Courier New", Font.PLAIN,16));
		exitButton.addActionListener(handler);							//add the listener to the button
		gui.cPane.add(exitButton);										//add the button to cPane
		
		gui.setVisible(true);												//set the visible to true
	}

	
	public void withdrawMoney(){					//the withdraw money gui

		gui = new GuiFrame();
		gui.getGuiFrame();
		gui.setTitle("Account Details");
		
		JLabel withdraw = new JLabel("Withdraw");					//create a withdraw title label
		withdraw.setBounds(250,25,300,100);							//set the style of the withdraw label
		withdraw.setFont(new Font("Courier New", Font.PLAIN,40));
		gui.cPane.add(withdraw);									//add the label to cPane
		
		JLabel withdrawMessage = new JLabel("Please enter the amount: ");		//create the withdraw label
		withdrawMessage.setBounds(130,170,400,100);								//set the style of the withdraw label
		withdrawMessage.setFont(new Font("Courier New", Font.PLAIN,17));		
		gui.cPane.add(withdrawMessage);											//add the label to cPane
		
		WithdrawButtonHandler handler = new WithdrawButtonHandler();			//create the handler
		
		amountField = new JTextField(15);									//create an amount field
		amountField.setBounds(370,205,200,25);								//set the style of the amount field
		amountField.setFont(new Font("Courier New", Font.PLAIN,17));		
		gui.cPane.add(amountField);											//add the field to cPane
		
		backButton = new JButton("Back");									//create a back button
		backButton.setBounds(110,340,110,50);								//set the style of the back button
		backButton.setFont(new Font("Courier New", Font.PLAIN,16));
		backButton.addActionListener(handler);							//add the listener to the button
		gui.cPane.add(backButton);											//add the button to cPane
		
		confirmButton = new JButton("Confirm");								//create a confirm button
		confirmButton.setBounds(550,340,110,50);							//set the style of the confirm button
		confirmButton.setFont(new Font("Courier New", Font.PLAIN,16));
		confirmButton.addActionListener(handler);							//add the listener to the button
		gui.cPane.add(confirmButton);										//add the button to cPane
		
		gui.setVisible(true);												//set the visible to true
	}
	
	public void lodgeMoney(){				//the lodge money gui

		gui = new GuiFrame();
		gui.getGuiFrame();
		gui.setTitle("Account Details");
		
		JLabel lodge = new JLabel("Lodge Money");					//create a lodge title label
		lodge.setBounds(250,25,300,100);							//set the style of the withdraw label
		lodge.setFont(new Font("Courier New", Font.PLAIN,40));
		gui.cPane.add(lodge);										//add the label to cPane
		
		JLabel lodgeMessage = new JLabel("Please enter the amount: ");		//create the lodge label
		lodgeMessage.setBounds(130,170,400,100);								//set the style of the lodge label
		lodgeMessage.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(lodgeMessage);											//add the label to cPane
		
		amountField = new JTextField(15);									//create an amount field
		amountField.setBounds(370,205,200,25);								//set the style of the amount field
		amountField.setFont(new Font("Courier New", Font.PLAIN,17));
		
		gui.cPane.add(amountField);											//add the field to cPane
		
		LodgeButtonHandler handler = new LodgeButtonHandler();			//create the handler
		
		backButton = new JButton("Back");									//create a back button
		backButton.setBounds(110,340,110,50);								//set the style of the back button
		backButton.setFont(new Font("Courier New", Font.PLAIN,16));
		backButton.addActionListener(handler);							//add the listener to the button
		gui.cPane.add(backButton);											//add the button to cPane
		
		confirmButton = new JButton("Confirm");								//create a confirm button
		confirmButton.setBounds(550,340,110,50);							//set the style of the confirm button
		confirmButton.setFont(new Font("Courier New", Font.PLAIN,16));
		confirmButton.addActionListener(handler);							//add the listener to the button
		gui.cPane.add(confirmButton);										//add the button to cPane
		
		gui.setVisible(true);												//set the visible to true
	}
	
	
	public void exit(){					//display the exit message and exit the system
		
		JOptionPane.showMessageDialog(null,"Thanks For Using! Bye...","Exit Message",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
		private class ShowAccountBalanceButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == backButton)
			{
				BankSystem bankSystem = new BankSystem();
				gui.setVisible(false);
			}
			else if(e.getSource() == exitButton)
			{
				JOptionPane.showMessageDialog(null,"Thanks For Using! Bye...","Exit Message",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	private class WithdrawButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == confirmButton)					//function when is clicked on the confirm button
			{
				
				try{												//start the transaction
				
				double amount = Double.parseDouble(amountField.getText());
				double balance = account.getAccountBalance();
				
				
				if(balance > amount)									//function if the transaction is successful
				{
					balance -= amount;
					JOptionPane.showMessageDialog(null,"Transaction Done");
				}
				else													//function if the transaction is fail
				{
					JOptionPane.showMessageDialog(null,"Invalid! Please enter the valid amount!");
				}
				
				account.setAccountBalance(balance);						//Set the latest account balance
				
				accountList.set(index,account);							//change the detail of the account in the list of the account
				
				AccountList accountL = new AccountList();				//create an accountList to save the account detail to the "accF.dat" file
				accountL.saveAccountList(accountList);
				
				BankSystem bankSystem = new BankSystem();				//back to the bank system
				gui.setVisible(false);
				}
				catch(Exception exception)
				{
					JOptionPane.showMessageDialog(null,"Retrieve Error","Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource() == backButton)						//function when is clicked on the back button
			{
				BankSystem bankSystem = new BankSystem();				//back to the bank system
				gui.setVisible(false);
			}
			
		}
	}
		private class LodgeButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == confirmButton)					//function when is clicked on the confirm button
			{
				try{
				double amount = Double.parseDouble(amountField.getText());
				double balance = account.getAccountBalance();
				
				if(amount <= 50)								//function if the transaction is fail
				{
					JOptionPane.showMessageDialog(null,"Invalid! Please enter the valid amount!");
				}
				else											//function if the transaction is successful
				{
					balance += amount;
					JOptionPane.showMessageDialog(null,"Transaction Done");
				}
				account.setAccountBalance(balance);				//Set the latest account balance
				
				accountList.set(index,account);					//change the detail of the account in the list of the account
				
				AccountList accountL = new AccountList();		//create an accountList to save the account detail to the "accF.dat" file
				accountL.saveAccountList(accountList);
				
				BankSystem bankSystem = new BankSystem();		//back to the bank system
				gui.setVisible(false);
				}
				catch(Exception exception)
				{
					JOptionPane.showMessageDialog(null,"Retrieve Error","Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource() == backButton)			//function when is clicked on the back button
			{
				BankSystem bankSystem = new BankSystem();
				gui.setVisible(false);
			}
			
		}
	}
}