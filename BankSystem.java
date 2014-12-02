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
	Account account1;
//	ArrayList<AccountDetails> accountList;
	GuiFrame gui;
	
	public BankSystem(){
		
		gui = new GuiFrame();
		gui.getGuiFrame();
		gui.setTitle("Bank System");
		
		try
		{
			Scanner input = new Scanner(new File("accountDetails.txt"));
			int accInputNumber = Integer.parseInt(input.nextLine());
			int accInputPassword = Integer.parseInt(input.nextLine());
			double accInputBalance = Double.parseDouble(input.nextLine());
			
			account1 = new Account(accInputNumber,accInputPassword,accInputBalance);
		
			JLabel label = new JLabel("Welcome!");
			gui.cPane.add(label);
			label.setBounds(300,25,300,100);
			label.setFont(new Font("Courier New", Font.PLAIN,40));
		
			
			FunctionButtonHandler handler = new FunctionButtonHandler();
			
			showAccountDetailButton = new JButton("Account Details");
			showAccountDetailButton.addActionListener(handler);
			showAccountDetailButton.setBounds(120,130,200,100);
			showAccountDetailButton.setFont(new Font("Courier New", Font.PLAIN,18));
			
			showAccountBalanceButton = new JButton("Balance");
			showAccountBalanceButton.addActionListener(handler);
			showAccountBalanceButton.setBounds(390,130,200,100);
			showAccountBalanceButton.setFont(new Font("Courier New", Font.PLAIN,20));
			
			withdrawButton = new JButton("Withdraw");
			withdrawButton.addActionListener(handler);
			withdrawButton.setBounds(120,280,200,100);
			withdrawButton.setFont(new Font("Courier New", Font.PLAIN,20));
			
		
			lodgeButton = new JButton("Lodge");
			lodgeButton.addActionListener(handler);
			lodgeButton.setBounds(390,280,200,100);
			lodgeButton.setFont(new Font("Courier New", Font.PLAIN,20));
		
			
			gui.cPane.add(showAccountDetailButton);
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
		catch(Exception exception)
		{
			JOptionPane.showMessageDialog(null,"Problem Occur","Error",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private class FunctionButtonHandler implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == showAccountDetailButton)
		{
			try{
					AccountDetails accD = new AccountDetails(account1.getAccountNum(),"Edward Sin",'M',20,"21th Nov 1994","115[A],An Sean Mhuileann, Kerry","(087)7796123");
					File acc = new File("account.dat");
					FileOutputStream output = new FileOutputStream(acc);
					ObjectOutputStream outStream = new ObjectOutputStream(output);
					
					outStream.writeObject(accD);
					outStream.close();
					FunctionList function = new FunctionList();
					function.showAccountDetails();
					gui.setVisible(false);
				}
				catch(IOException exception){
					JOptionPane.showMessageDialog(null,"Error occurs");
				}
		}
		else if(e.getSource() == withdrawButton)
		{
			try{
			
					File acc = new File("account.dat");
					FileOutputStream output = new FileOutputStream(acc);
					ObjectOutputStream outStream = new ObjectOutputStream(output);
				
					outStream.writeObject(account1);
					outStream.close();
					FunctionList function = new FunctionList();
					function.withdrawMoney();
					gui.setVisible(false);
			}
			catch(IOException exception){
				JOptionPane.showMessageDialog(null,"Error occurs");
			}
		}
		else if(e.getSource() == lodgeButton)
		{
			try{
					File acc = new File("account.dat");
					FileOutputStream output = new FileOutputStream(acc);
					ObjectOutputStream outStream = new ObjectOutputStream(output);
				
					outStream.writeObject(account1);
					outStream.close();
					FunctionList function = new FunctionList();
					function.lodgeMoney();
					gui.setVisible(false);
			}
			catch(IOException exception){
				JOptionPane.showMessageDialog(null,"Error occurs");
			}
		}
		else if(e.getSource() == showAccountBalanceButton)
		{
			try{
					File acc = new File("account.dat");
					FileOutputStream output = new FileOutputStream(acc);
					ObjectOutputStream outStream = new ObjectOutputStream(output);
				
					outStream.writeObject(account1);
					outStream.close();
					FunctionList function = new FunctionList();
					function.showAccountBalance();
					gui.setVisible(false);
			}
			catch(IOException exception){
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
	
}