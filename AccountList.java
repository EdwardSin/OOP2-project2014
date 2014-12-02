//AccountList.java
import java.util.*;
import java.io.*;
import javax.swing.*;
public class AccountList 
{
	ArrayList<Account> accountList = new ArrayList<Account>();
		
	ArrayList<AccountDetails> accountDetailsList = new ArrayList<AccountDetails>();;
	
	
	public void addAccount(){
		try{
		accountList = new ArrayList<Account>();
		accountDetailsList = new ArrayList<AccountDetails>();;
		Account account1 = new Account(123456,123456,5000);
		accountList.add(account1);
		AccountDetails accountD1 = new AccountDetails(123456,"Edward Sin", 'M', 20, "21Nov1994", "115[A] An Sean Mhuileann, Kerry", "(087)7796224");
		accountDetailsList.add(accountD1);
	
		saveAccountList(accountList,accountDetailsList);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error");
		}
	}
	
	
	public void saveAccountList(ArrayList<Account> accountList, ArrayList<AccountDetails> accountDetailsList){
		
		try{
		File account3 = new File("account3.dat");
		
		FileOutputStream fos = new FileOutputStream(account3);
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(accountList);
		oos.writeObject(accountDetailsList);
		
		oos.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error");
		}
	}
	public void retrieveAccountList(){
		
		try
		{
			File account3 = new File("account3.dat");
			FileInputStream fis = new FileInputStream(account3);
			ObjectInputStream ois = new ObjectInputStream(fis);
			accountList = (ArrayList<Account>) ois.readObject();
			accountDetailsList = (ArrayList<AccountDetails>) ois.readObject();
			
			ois.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error!!!");
		}

	}
	
	public ArrayList getRetrieveAccountList()
	{
		return accountList;
	}
	public ArrayList getRetrieveAccountDetailsList()
	{
		return accountDetailsList;
	}
	
	public static void main(String args[])
	{
		AccountList list = new AccountList();
		list.addAccount();
		
	}
}