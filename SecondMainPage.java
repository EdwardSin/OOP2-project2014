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
	static int index;
	GuiFrame gui; 
	static ArrayList<Account> accountList;
	static Account account;
	boolean valid;
	AccountList accountL;
	
	public SecondMainPage(){
		
		accountL = new AccountList();							//Create an object of AccountList
		accountL.retrieveAccountList();							//retrieve the data of "accF.data" file
		
		accountList = accountL.getRetrieveAccountList();		//get the retrieve Account List
		
		gui= new GuiFrame();
		gui.getGuiFrame();
		
		gui.setTitle("Bank System");
	
		JLabel label = new JLabel("AIB Bank");								//set the label
		
		gui.cPane.add(label);
		label.setBounds(275,25,300,100);								//set the style of label
		label.setFont(new Font("Courier New", Font.PLAIN,40));
		
		JLabel accountLabel = new JLabel("Account: ");					//create account label
		accountLabel.setBounds(175,150,140,100);						//set the style of account label
		accountLabel.setFont(new Font("Courier New", Font.PLAIN,25));
		gui.cPane.add(accountLabel);									//add the button to cPane
		
		JLabel passwordLabel = new JLabel("Password: ");				//create password label
		passwordLabel.setBounds(175,190,160,100);						//set the stle of password label
		passwordLabel.setFont(new Font("Courier New", Font.PLAIN,25));
		gui.cPane.add(passwordLabel);									//add the button to cPane
		
		accountField = new JTextField(8);								//create account field
		accountField.setBounds(340,185,250,30);							//set the style of account field
		accountField.setFont(new Font("Courier New", Font.PLAIN,30));
		gui.cPane.add(accountField);									//add the field to cPane
		
		passwordField = new JPasswordField(8);							//create password field
		passwordField.setBounds(340,220,250,30);						//set the style of password field
		passwordField.setFont(new Font("Courier New", Font.PLAIN,30));
		gui.cPane.add(passwordField);									//add the password field to cPane
		
		ButtonHandler handler = new ButtonHandler();		//create the handler
		
		confirmButton = new JButton("Confirm");				//create a confirm button
		confirmButton.setBounds(390,305,110,50);			//set the style of confirm button
		confirmButton.setFont(new Font("Courier New", Font.PLAIN,16));
		confirmButton.addActionListener(handler);			//add the listener to the button
		gui.cPane.add(confirmButton);						//add the button to cPane
		
		exitButton = new JButton("Exit");					//create an exit button
		exitButton.setBounds(260,305,110,50);				//set the style of button
		exitButton.setFont(new Font("Courier New", Font.PLAIN,16));
		exitButton.addActionListener(handler);				//add the listener to the button
		gui.cPane.add(exitButton);							//add the button to cPane
		
		gui.setVisible(true);
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == exitButton)
			{
				FunctionList function = new FunctionList();						//create the function object to use the exit method
				function.exit();
			}
			else if(e.getSource() == confirmButton)
			{
				try{
					accountNumber = Integer.parseInt(accountField.getText());		//get the text which the user type in to the account field
					accountPassword = Integer.parseInt(passwordField.getText());	//get the text which the user type in to the password field
				
						Iterator<Account> itr = accountList.iterator();				//create the iterator to check the accountNumber and accountPassword whether is in the account list or not
						
							while(itr.hasNext())
							{
								account = (Account) itr.next();
								
								if(accountNumber == account.getAccountNum() && accountPassword == account.getAccountPass())
								{
									index = accountList.indexOf(account);
									BankSystem bankSystem = new BankSystem();
									gui.setVisible(false);
									valid = true;
								}
								else
								{
									valid=false;
									break;
								}
							}
							if(valid == false)													//display an error message if there is no such kind of account or wrong password
							{
								JOptionPane.showMessageDialog(null,"Please enter the valid account number and password","Error!!",JOptionPane.INFORMATION_MESSAGE);
							}
				}
				catch(NumberFormatException NFException)
				{
					JOptionPane.showMessageDialog(null,"1Please enter the valid account number and password","Error!!",JOptionPane.INFORMATION_MESSAGE);
				}
			}	
		}
	}
}