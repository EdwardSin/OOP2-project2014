import java.io.*;
import java.util.*;
import javax.swing.*;

public class Example{
	
	
	public static void main(String args[])
	{
		ArrayList<Account> accountList = new ArrayList<Account>();
		ArrayList<AccountDetails> accountDetailsList = new ArrayList<AccountDetails>();
		Account account;
		try{
			
			AccountList aaa = new AccountList();
			aaa.retrieveAccountList();
			
			accountList = aaa.getRetrieveAccountList();
			accountDetailsList = aaa.getRetrieveAccountDetailsList();
			
			Iterator itr = accountList.iterator();
				
			while(itr.hasNext())
			{
				account = (Account)itr.next();
				System.out.println(account.toString());
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"HHH");
		}
	}
}