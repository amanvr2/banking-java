package project;
//NEW ONE
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


//creating a class 
public class BankAccount {
	  
	 private String bankName;
	 private String branchName;
	 private String ifscCode; 
     private long accNumber;
	 private String bankHolderName;
	 private String accType;
	 private double balance;
	  //Constructor with all fields 
	public BankAccount(String bankName, String branchName, String ifscCode, long accNumber, String bankHolderName,
			String accType,double balance) {
		super();
		this.bankName = bankName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.accNumber = accNumber;
		this.bankHolderName = bankHolderName;
		this.accType = accType;
		this.balance = balance;
	}
	//Constructor with no fields
	public BankAccount() {
		
	}
	//Setters and Getters for all fields 
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public String getBankHolderName() {
		return bankHolderName;
	}
	public void setBankHolderName(String bankHolderName) {
		this.bankHolderName = bankHolderName;
	}
	
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	//Method to deposit money in customer account
	 public void deposit(double amount) {
		  this.balance+=amount;
	  }
	//Method to deposit money in customer account
	  public void withdraw(double amount) {
		  this.balance-=amount;
	  }
	//Method to get balance of customer account
	  public void currentbalance() {
		  System.out.println(balance);
		  //balance=this.balance;
	  }
	//Method to transfer money to another account 
	  public void transferamount(BankAccount destacc,double amount) {
		  this.balance-=amount;
		  destacc.balance+=amount;
	  }
	//Method to send customer data to file
	  public String writeToFile() {
			return  bankName+","+branchName+","+ifscCode+","+accNumber+","+bankHolderName+","+accType+","+balance;
		}
	  
	@Override
	public String toString() {
		return  
				  " BankName=" + bankName + System.lineSeparator()  
				+ " BranchName=" + branchName +System.lineSeparator()
				+ " IfscCode=" + ifscCode + System.lineSeparator()
				+ " AccountNumber=" + accNumber + System.lineSeparator()
				+ " BankHolderName=" + bankHolderName + System.lineSeparator()
				+ " AccountType=" + accType + System.lineSeparator()
				+ " Balance=" + balance ;
	}
	
	
	  
	  
}
