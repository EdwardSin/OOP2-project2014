//AccountList.java
import java.util.*;
import java.io.*;
import javax.swing.*;
public class AccountList 
{
	ArrayList<Account> accountList = new ArrayList<Account>();
		
//	ArrayList<AccountDetails> accountDetailsList = new ArrayList<AccountDetails>();;
	
	
	public void addAccount(){
		try{
		accountList = new ArrayList<Account>();
	//	accountDetailsList = new ArrayList<AccountDetails>();;
		Account account1 = new Account(123456,123456,5000);
		accountList.add(account1);
	//	AccountDetails accountD1 = new AccountDetails(123456,"Edward Sin", 'M', 20, "21Nov1994", "115[A] An Sean Mhuileann, Kerry", "(087)7796224");
	//	accountDetailsList.add(accountD1);
	
		saveAccountList(accountList);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error");
		}
	}
	
	
	public void saveAccountList(ArrayList<Account> accountList){
		
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
	public void retrieveAccountList(){
		
		try
		{
			File accF = new File("accF.dat");
			FileInputStream fis = new FileInputStream(accF);
			ObjectInputStream ois = new ObjectInputStream(fis);
			accountList = (ArrayList<Account>) ois.readObject();
//			accountDetailsList = (ArrayList<AccountDetails>) ois.readObject();
			
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
	
	public static void main(String args[])
	{
		AccountList list = new AccountList();
		list.addAccount();
		
	}
}