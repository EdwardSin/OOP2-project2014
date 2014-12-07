//Account.java
 
import java.io.*;
/**
 *<h1>Account</h1>
 *This program creates, modifies and gets
 *the details of an account<p>
 *
 *@author Edward Sin
 *@version 1.0
 *@since 2014-04-12
 */


public class Account implements Serializable{
	
	
	private int accountNum;
	private int accountPass;
	private double accountBalance;
	
	/**Class non-arg constructor
	 */
	public Account(){
		setAccountNum(0);
		setAccountPass(0);
		setAccountBalance(0);
	}
	/**Class 1-arg constructor
	 *
	 */
	 
	public Account(int accountNum)
	{
		setAccountNum(accountNum);
	}
	/**Class multiple-arg constructor
	 */
	public Account(int accountNum, int accountPass, double accountBalance)
	{
		setAccountNum(accountNum);
		setAccountPass(accountPass);
		setAccountBalance(accountBalance);
	}
	/**
	 *Change the account number of this account.
	 *This may involve a lengthy legal process.
	 *@param accountNum An account number.
	 **/
	public void setAccountNum(int accountNum)
	{
		this.accountNum = accountNum;
	}
	/**
	 *Get the account number of an account.
	 *@return get an account number.
	 */
	public int getAccountNum()
	{
		return accountNum;
	}
	/**
	 *Change the account password of this account.
	 *This may involve a lengthy legal process.
	 *@param accountPass An account password.
	 **/	
	public void setAccountPass(int accountPass)
	{
		this.accountPass = accountPass;
	}
	
	/**
	 *Get the account password of an account.
	 *@return get an account password.
	 */
	public int getAccountPass()
	{
		return accountPass;
	}
	/**
	 *Change the account balance of this account.
	 *This may involve a lengthy legal process.
	 *@param accountBalance An account balance.
	 **/
	public void setAccountBalance(double accountBalance)
	{
		this.accountBalance = accountBalance;
	}
	
	/**
	 *Get the account balance of an account.
	 *@return get an account balance.
	 */
	public double getAccountBalance()
	{
		return accountBalance;
	}
	/**
	 *Lodge and add the balance from an account balance.
	 *This may involve a lengthy legal process.
	 *@param money The amonut which is required to lodge.
	 **/
	public void lodgeMoney(int money)
	{
		this.accountBalance += money;
	}
	
	/**
	 *Withdraw and deduct the balance from an account balance.
	 *This may involve a lengthy legal process.
	 *@param money The amount which is required to withdraw.
	 **/
	public void withdrawMoney(int money)
	{
		this.accountBalance -= money;
	}
	/**
	 *Return the account number and the balance of an account
	 *@return The details of an account*/
	public String toString()
	{
		return("Account No: " + getAccountNum()+
				"\nAccount Pass: " + getAccountPass() +
				"\nCurrent Balance: "+ getAccountBalance());
	}
}