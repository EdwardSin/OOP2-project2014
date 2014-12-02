import java.io.*;

public class AccountDetails extends Account implements Serializable{
	
	private String name;
	private String address;
	private String phoneNum;
	private char gender;
	private int age;
	private String dateOfBirth;
	
	//non-arg constructor
	public AccountDetails()
	{
		this(0," ",' ',0," "," "," ");
	}
	//multiple-args constructor
	public AccountDetails(int accountNum,String name, char gender,int age,String dateOfBirth,String address, String phoneNum)
	{
		super(accountNum);
		setName(name);
		setGender(gender);
		setAge(age);
		setDateOfBirth(dateOfBirth);
		setAddress(address);
		setPhonenum(phoneNum);
	}
	//Changes the name of the defined account
	public void setName(String name)
	{
		this.name = name;
	}
	//Gets the name of the defined account
	public String getName()
	{
		return name;
	}
	//Changes the address of the defined account
	public void setAddress(String address)
	{
		this.address = address;
	}
	//Gets the address of the defined account
	public String getAddress()
	{
		return address;
	}
	//Changes the gender of the defined account
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	//Gets the gender of the defines account
	public char getGender()
	{
		return gender;
	}
	//Changes the phone number of the defined account
	public void setPhonenum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}
	//Gets the phone number of the defined account
	public String getPhonenum()
	{
		return phoneNum;
	}
	//Changes the age of the defined account
	public void setAge(int age)
	{
		this.age = age;
	}
	//Gets the age of the defined account
	public int getAge()
	{
		return age;
	}
	//Changes the date of birth of the defined account
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	//Gets the date of birth of the defined account
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	//Displays the account details
	public String toString()
	{
		return "Account Name: " + name +
				"Gender: " + gender +
				"Age: " + age +
				"Date Of Birth: " + dateOfBirth +
				"Address: " + address +
				"Phone Number: " + phoneNum;
	}
}