
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class FunctionList extends JFrame{
	
	JButton backButton;
	JButton exitButton;
	JButton confirmButton;
	JTextField amountField;
	Account account1;
	GuiFrame gui;
	
	public void showAccountDetails(){
		
		AccountDetails accountDetails = new AccountDetails();
		try{
		File acc = new File("account.dat");
		FileInputStream input = new FileInputStream(acc);
		ObjectInputStream inStream = new ObjectInputStream(input);
		
		accountDetails =(AccountDetails) inStream.readObject();
		
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Retrieve Error");
		}
		
		gui = new GuiFrame();
		gui.getGuiFrame();
		gui.setTitle("Account Details");
		
		JLabel accountD = new JLabel("Account Details");
		accountD.setBounds(250,25,300,100);
		accountD.setFont(new Font("Courier New", Font.PLAIN,40));
		
		gui.cPane.add(accountD);
		JLabel accountNumber = new JLabel("Account Name: " + accountDetails.getName());
		accountNumber.setBounds(115,90,400,100);
		accountNumber.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(accountNumber);
		
		JLabel accountGender = new JLabel("Gender: " + accountDetails.getGender());
		accountGender.setBounds(115,140,400,100);
		accountGender.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(accountGender);
		
		JLabel accountAge = new JLabel("Age: " + accountDetails.getAge());
		accountAge.setBounds(115,190,400,100);
		accountAge.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(accountAge);
		
		JLabel accountAddress = new JLabel("Address:" + accountDetails.getAddress());
		accountAddress.setBounds(340,145,400,100);
		accountAddress.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(accountAddress);
		
		JLabel accountDateOfBirth = new JLabel("Date Of Birth: " + accountDetails.getDateOfBirth());
		accountDateOfBirth.setBounds(340,205,400,100);
		accountDateOfBirth.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(accountDateOfBirth);
		
		JLabel accountPhoneNum = new JLabel("PhoneNum: " + accountDetails.getPhonenum());
		accountPhoneNum.setBounds(340,255,400,100);
		accountPhoneNum.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(accountPhoneNum);
		
		ShowAccountDetailsButtonHandler handler = new ShowAccountDetailsButtonHandler();
		
		backButton = new JButton("Back");
		backButton.setBounds(110,340,110,50);
		backButton.setFont(new Font("Courier New", Font.PLAIN,16));
		backButton.addActionListener(handler);
		gui.cPane.add(backButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(550,340,110,50);
		exitButton.setFont(new Font("Courier New", Font.PLAIN,16));
		exitButton.addActionListener(handler);
		gui.cPane.add(exitButton);
		gui.setVisible(true);
		
		
	}

		public void showAccountBalance(){
				
		account1 = new Account();
		try{
			File acc = new File("account.dat");
			FileInputStream input = new FileInputStream(acc);
			ObjectInputStream inStream = new ObjectInputStream(input);
			
			account1 =(Account) inStream.readObject();
			inStream.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Retrieve Error");
		}
		
		gui = new GuiFrame();
		gui.getGuiFrame();
		gui.setTitle("Account Details");
		
		JLabel balanceMessage = new JLabel("Balance: " + String.format("%.2f",account1.getAccountBalance()));
		balanceMessage.setBounds(230,130,400,100);
		balanceMessage.setFont(new Font("Courier New", Font.PLAIN,20));
		gui.cPane.add(balanceMessage);
		
		
		ShowAccountBalanceButtonHandler handler = new ShowAccountBalanceButtonHandler();
		
		backButton = new JButton("Back");
		backButton.setBounds(110,340,110,50);
		backButton.setFont(new Font("Courier New", Font.PLAIN,16));
		backButton.addActionListener(handler);
		gui.cPane.add(backButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(550,340,110,50);
		exitButton.setFont(new Font("Courier New", Font.PLAIN,16));
		exitButton.addActionListener(handler);
		gui.cPane.add(exitButton);
		
		gui.setVisible(true);
	}

	
	public void withdrawMoney(){
		
		account1 = new Account();
		try{
			File acc = new File("account.dat");
			FileInputStream input = new FileInputStream(acc);
			ObjectInputStream inStream = new ObjectInputStream(input);
		
			account1 =(Account) inStream.readObject();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Retrieve Error");
		}
		gui = new GuiFrame();
		gui.getGuiFrame();
		gui.setTitle("Account Details");
		
		JLabel withdraw = new JLabel("Withdraw");
		withdraw.setBounds(250,25,300,100);
		withdraw.setFont(new Font("Courier New", Font.PLAIN,40));
		gui.cPane.add(withdraw);
		
		JLabel withdrawMessage = new JLabel("Please enter the amount: ");
		withdrawMessage.setBounds(130,170,400,100);
		withdrawMessage.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(withdrawMessage);
		
		WithdrawButtonHandler handler = new WithdrawButtonHandler();
		
		amountField = new JTextField(15);
		amountField.setBounds(370,205,200,25);
		amountField.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(amountField);
		
		backButton = new JButton("Back");
		backButton.setBounds(110,340,110,50);
		backButton.setFont(new Font("Courier New", Font.PLAIN,16));
		backButton.addActionListener(handler);
		gui.cPane.add(backButton);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(550,340,110,50);
		confirmButton.setFont(new Font("Courier New", Font.PLAIN,16));
		confirmButton.addActionListener(handler);
		gui.cPane.add(confirmButton);
		
		gui.setVisible(true);
	}
	
	public void lodgeMoney(){
				
		account1 = new Account();
		try{
			File acc = new File("account.dat");
			FileInputStream input = new FileInputStream(acc);
			ObjectInputStream inStream = new ObjectInputStream(input);
			
			account1 =(Account) inStream.readObject();
			inStream.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Retrieve Error");
		}
		
		gui = new GuiFrame();
		gui.getGuiFrame();
		gui.setTitle("Account Details");
		
		JLabel lodge = new JLabel("Lodge Money");
		lodge.setBounds(250,25,300,100);
		lodge.setFont(new Font("Courier New", Font.PLAIN,40));
		gui.cPane.add(lodge);
		
		JLabel lodgeMessage = new JLabel("Please enter the amount: ");
		lodgeMessage.setBounds(130,170,400,100);
		lodgeMessage.setFont(new Font("Courier New", Font.PLAIN,17));
		gui.cPane.add(lodgeMessage);
		
		amountField = new JTextField(15);
		amountField.setBounds(370,205,200,25);
		amountField.setFont(new Font("Courier New", Font.PLAIN,17));
		
		gui.cPane.add(amountField);
		
		LodgeButtonHandler handler = new LodgeButtonHandler();
		
		backButton = new JButton("Back");
		backButton.setBounds(110,340,110,50);
		backButton.setFont(new Font("Courier New", Font.PLAIN,16));
		backButton.addActionListener(handler);
		gui.cPane.add(backButton);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(550,340,110,50);
		confirmButton.setFont(new Font("Courier New", Font.PLAIN,16));
		confirmButton.addActionListener(handler);
		gui.cPane.add(confirmButton);
		
		gui.setVisible(true);
	}
	
	
	public void exit(){
		
		JOptionPane.showMessageDialog(null,"Thanks For Using! Bye...","Exit Message",JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);
	}
	
	private class ShowAccountDetailsButtonHandler implements ActionListener{
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
			if(e.getSource() == confirmButton)
			{
				
				try{
				
				double amount = Double.parseDouble(amountField.getText());
				double balance = account1.getAccountBalance();
				
				if(balance > amount)
					balance -= amount;
				else
					JOptionPane.showMessageDialog(null,"Invalid! Please enter the valid amount!");
				
				account1.setAccountBalance(balance);
				
				File acc = new File("account.dat");
				FileOutputStream output = new FileOutputStream(acc);
				ObjectOutputStream outStream = new ObjectOutputStream(output);
		
				outStream.writeObject(account1);
				outStream.close();
				
				FileOutputStream fOutput = new FileOutputStream(new File("accountDetails.txt"));
				PrintWriter pWriter = new PrintWriter(fOutput);
				
				pWriter.println(account1.getAccountNum());
				pWriter.println(account1.getAccountPass());
				pWriter.println(account1.getAccountBalance());
				
				pWriter.close();
				
				JOptionPane.showMessageDialog(null,"Transaction Done");
				BankSystem bankSystem = new BankSystem();
				setVisible(false);
				}
				catch(Exception exception)
				{
					JOptionPane.showMessageDialog(null,"Retrieve Error","Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource() == backButton)
			{
				BankSystem bankSystem = new BankSystem();
				gui.setVisible(false);
			}
			
		}
	}
		private class LodgeButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == confirmButton)
			{
				try{
				double amount = Double.parseDouble(amountField.getText());
				double balance = account1.getAccountBalance();
				
				balance += amount;
				
				account1.setAccountBalance(balance);
				
				File acc = new File("account.dat");
				FileOutputStream output = new FileOutputStream(acc);
				ObjectOutputStream outStream = new ObjectOutputStream(output);
		
				outStream.writeObject(account1);
				outStream.close();
				
				FileOutputStream fOutput = new FileOutputStream(new File("accountDetails.txt"));
				PrintWriter pWriter = new PrintWriter(fOutput);
				
				pWriter.println(account1.getAccountNum());
				pWriter.println(account1.getAccountPass());
				pWriter.println(account1.getAccountBalance());
				
				pWriter.close();
				
				JOptionPane.showMessageDialog(null,"Transaction Done");
				BankSystem bankSystem = new BankSystem();
				setVisible(false);
				}
				catch(Exception exception)
				{
					JOptionPane.showMessageDialog(null,"Retrieve Error","Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource() == backButton)
			{
				BankSystem bankSystem = new BankSystem();
				gui.setVisible(false);
			}
			
		}
	}
	
	
	
	
	

}