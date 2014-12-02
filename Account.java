//Account.java
/**@author Edward Sin
 */ 
import java.io.*;

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
	 *Changes the account number of this account.
	 *This may involve a lengthy legal process.
	 *@param accountNum This account's new account number.
	 **/
	public void setAccountNum(int accountNum)
	{
		this.accountNum = accountNum;
	}
	/**
	 *Gets the account number of an account.
	 *@return this account's account number.
	 */
	public int getAccountNum()
	{
		return accountNum;
	}
	/**
	 *Changes the account password of this account.
	 *This may involve a lengthy legal process.
	 *@param accountPass This account's new account password.
	 **/	
	public void setAccountPass(int accountPass)
	{
		this.accountPass = accountPass;
	}
	
	/**
	 *Gets the account password of an account.
	 *@return this account's account password.
	 */
	public int getAccountPass()
	{
		return accountPass;
	}
	/**
	 *Changes the account balance of this account.
	 *This may involve a lengthy legal process.
	 *@param accountBalance This account's new account balance.
	 **/
	public void setAccountBalance(double accountBalance)
	{
		this.accountBalance = accountBalance;
	}
	
	/**
	 *Gets the account balance of an account.
	 *@return this account's account balance.
	 */
	public double getAccountBalance()
	{
		return accountBalance;
	}
	/**
	 *Lodge and adding the balance from an account balance.
	 *This may involve a lengthy legal process.
	 *@param money The lodgement which is required to lodge.
	 **/
	public void lodgeMoney(int money)
	{
		this.accountBalance += money;
	}
	
	/**
	 *Withdraw and deduct the balance from an account balance.
	 *This may involve a lengthy legal process.
	 *@param money The withdrawal which is required to withdraw.
	 **/
	public void withdrawMoney(int money)
	{
		this.accountBalance -= money;
	}
	/**
	 *Returened the account number and the balance of an account
	 *@return The details of an account*/
	public String toString()
	{
		return("Account No: " + getAccountNum()+
				"\nCurrent Balance: "+ getAccountBalance());
	}
}