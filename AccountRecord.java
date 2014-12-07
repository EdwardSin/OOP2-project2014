//AccountList.java
import java.util.*;
import java.io.*;
import javax.swing.*;

public class AccountRecord
{
	private ArrayList<Account> accountList= new ArrayList<Account>();;
	
	public void addAccount(Account account){				//add the attribute to the accountList
		try{
		accountList.add(account);
		saveAccountList(accountList);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error");
		}
	}
	
	
	public void saveAccountList(ArrayList<Account> accountList){			//save the accountlist to a file called "accF.dat"
		
		try{
		File accF = new File("accF.dat");
		
		FileOutputStream fos = new FileOutputStream(accF);
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(accountList);
		
		oos.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error");
		}
	}
	public void retrieveAccountList(){							//retrieve the accountlist from the file called "accF.dat"
		
		try
		{
			File accF = new File("accF.dat");
			FileInputStream fis = new FileInputStream(accF);
			ObjectInputStream ois = new ObjectInputStream(fis);
			accountList = (ArrayList<Account>) ois.readObject();
			
			ois.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error!!!");
		}

	}
	
	public ArrayList getRetrieveAccountList()					//get the accountList which is just retrieve from the file
	{
		return accountList;
	}
	
	public static void main(String args[])						//initiate/create an account and store it in the "accF.dat"
	{
		Account account;
		AccountRecord list = new AccountRecord();
		
		account = new Account(654321,123456,5000);
		list.addAccount(account);
		
		account= new Account(123456,123456,5000);
		list.addAccount(account);
		
		account= new Account(1223478,123456,5000);
		list.addAccount(account);
	}
}