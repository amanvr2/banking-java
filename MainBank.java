package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.in.BankAccount;

//creating main class
public class MainBank {
	
	public static void main(String[] args) throws IOException {

		Scanner sc =new Scanner(System.in);
		ArrayList<BankAccount> empList=new ArrayList<>();  //ArrayList to store customers data 
		FileWriter emp = new FileWriter("big.txt",true);  //creating file
		PrintWriter pw=new PrintWriter(emp);
		BufferedReader br=new BufferedReader(new FileReader("big.txt")); //Object to read data from file
		int s ;
		int s1;
		
		readFromFile(empList);	//Calling method
		do {	
			  System.out.println("Welcome To CIBC Bank");
		      System.out.println("Press 1 to Add Customer or 2 to do other tasks:");
              s1=sc.nextInt();
        
       		if(s1==1) {      	   
       		  filldata(empList,emp,pw); //calling method
	       } else if(s1==2) {
			   BankAccount acc=null;
			   BankAccount acc1=null;
                 
			
			    System.out.println(" 1.Account Details");
				System.out.println(" 2.Deposit Money");
				System.out.println(" 3.Withdraw Money");
				System.out.println(" 4.Balance Enquiry");
				System.out.println(" 5.Transfer Amount");
				System.out.println(" 6.Electricity Bill");
				
				System.out.println("Enter One option");
                int option=sc.nextInt();sc.nextLine();
                switch(option) {               
                case 1:             
                	System.out.println("Enter Bank Account Number:");
                	long num0=sc.nextLong();
                    acc=search(empList,num0); //calling search method
          
                	if(acc!=null) {
                		System.out.println("Account Details:"+System.lineSeparator()+acc);
                	} else {
                	
                  		 System.out.println("Please open Account first or enter correct details");
                    }
                   break;
                case 2:
               	    FileWriter emp1 = new FileWriter("big.txt",false);
             		PrintWriter pw1=new PrintWriter(emp1);
                	System.out.println("Enter Bank Account Number:");
                	long num=sc.nextLong();
                	acc=search(empList,num); //calling search method
                	
                  if(acc!=null) {
               		 System.out.println("Enter Deposit Amount:");
                     double amount=sc.nextDouble();
                     acc.deposit(amount);
                
              	     System.out.println(amount +" is credited to your account:");
                     System.out.println("current balance:");
            	     acc.currentbalance();
                   for(BankAccount ac:empList) {
            	     pw1.println(ac.writeToFile());
            	     }
 				     pw1.close();
 				 
                   }else {
               		 System.out.println("Please open account first:");
                  }
                 break;
                case 3:
                	  FileWriter emp2 = new FileWriter("big.txt",false);
              		  PrintWriter pw2=new PrintWriter(emp2);
                	  System.out.println("Enter Bank Account Number");
                 	  long num1=sc.nextLong();
                      acc=search(empList,num1); //calling search method
                    
                  if(acc!=null) {
                  	  System.out.println("Enter Withdraw Amount");
                      double amount=sc.nextDouble();
                      acc.withdraw(amount);
                 	  System.out.println(amount +" is debited from your account");
               	      System.out.println("Current Balance:");
               	      acc.currentbalance();
                   
               	  for(BankAccount ac1:empList) {
               	    pw2.println(ac1.writeToFile());
               	  }
                      pw2.close();
                  
                   }else{
                  		 System.out.println("Please open account first:");
                     }
                	
                 break;
                case 4:
                    System.out.println("Enter Bank Account Number:");
                 	long num2=sc.nextLong();
                 	acc=search(empList,num2); //calling search method
                if(acc!=null) {
                  System.out.println("Current balance:");
              	  acc.currentbalance();
                  }else{
                 		 System.out.println("Please open account first:");
                    }
                break;
               case 5:
                    FileWriter emp3 = new FileWriter("big.txt",false);
               		PrintWriter pw3=new PrintWriter(emp3);
                	System.out.println("Enter Bank Account Number to be tranferred from:");
                 	long num3=sc.nextLong();
                 	acc=search(empList,num3);  //calling search method
                 	System.out.println("Enter Bank Account number for which amount to be transferred:");
                 	long num4=sc.nextLong();
                    acc1=search(empList,num4);  //calling search method
                	if(acc!=null && acc1!=null) {
                     	 System.out.println("Enter Transfer Amount:");
                         double amount=sc.nextDouble();
                         acc.transferamount(acc1, amount);
                         System.out.println(amount +" is transfered to "+ acc1.getAccNumber()+ " Account number");
                         System.out.println("Current Balance:");
                      	 acc.currentbalance();
                      	
                       for(BankAccount ac2:empList) {
                          	 pw3.println(ac2.writeToFile());
                          	 }
                           pw3.close();
                     
                     	 
                	}else {
                		 System.out.println("Please open Account first & Enter Correct Details:");
                   }
                 break;
                case 6:
                    FileWriter emp4 = new FileWriter("big.txt",false);
               		PrintWriter pw4=new PrintWriter(emp4);
                	System.out.println("Enter Bank Number:");
                 	long num5=sc.nextLong();
                 	acc=search(empList,num5);   //calling search method
                 if(acc!=null ){
                		BankAccount acc2=new BankAccount(null, null, null, 5678,"Electricity",null,5000);
                		 System.out.println("Enter Elecricity Bill Amount:");
                         double amount=sc.nextDouble();
                         acc.transferamount(acc2, amount);
                         System.out.println(amount +" is paid to Electricity Account from your Account:");
                         System.out.println("Current Balance:");
                         acc.currentbalance();
                         for(BankAccount ac2:empList) {
                          	 pw4.println(ac2.writeToFile());
                          	 }
                           pw4.close();
                       
                 }else {
                	 System.out.println("Please open Account first & Enter Correct Details:");
                  }
                      break;
                	  default :
                	  System.out.println("Error invalid option Please Choose Correct One");
			 } //Switch loop closed         
        }//else if closed
	       else {
        	 System.out.println("Error invalid selection");
        }
        System.out.println("Press 0 to Stop Execution or any number to continue to Start Menu:");
	        s=sc.nextInt();
        
	    }while(s!=0); 
		System.out.println(" Thank you please visit again");
	}
	//Method for reading data from file 
    public static void readFromFile(ArrayList<BankAccount> empList) throws IOException
	  {
		FileInputStream empFile=new FileInputStream("big.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(empFile));
		
		BankAccount acc11;
		String line;
            while((line=br.readLine())!=null) {
			
			String fields[]=line.split(",");
			String bankname=fields[0];
			String branchname=fields[1];
			String ifsccode=fields[2];
			long accnumber=Long.parseLong(fields[3]);
			String accoundholdername=fields[4];
            String accType=fields[5];
			double salary=Double.parseDouble(fields[6]);
				acc11=new BankAccount(bankname,branchname,ifsccode,accnumber,accoundholdername,accType,salary);
				empList.add(acc11);
				}
}
      //Method to search customer data in ArrayList
	public static BankAccount search(ArrayList<BankAccount>empList, long accNumber) {
		for(BankAccount st:empList) {
			if(st.getAccNumber()==accNumber) {
				return st;
			}}
		return null;
		
	}
	   //Method for filling data
	public static ArrayList<BankAccount> filldata(ArrayList<BankAccount> empList,FileWriter emp,PrintWriter pw) throws IOException {
		Scanner sc =new Scanner(System.in);
         int s;
		do {	
            	
				 BankAccount acc=null; 
	                   acc=new BankAccount();
	                   System.out.println("Enter Account details");
	                		  
	                   System.out.println("Enter Bank Name");
	                   acc.setBankName(sc.next());
	                   System.out.println("Enter Branch Name");
	                   acc.setBranchName(sc.next());
	                   System.out.println("Enter IFSC Code");
	                   acc.setIfscCode(sc.next());
	                   System.out.println(" Enter Account Number");
	                   acc.setAccNumber(sc.nextLong());sc.nextLine();
	                   System.out.println("Enter Account Holder Name");
	                   acc.setBankHolderName(sc.next());
	                   System.out.println("Enter Account Type");
	                   acc.setAccType(sc.next());
	                   System.out.println("Enter Account Balance");
	                   acc.setBalance(sc.nextDouble());
	                   System.out.println("Account created successfully");
	                   empList.add(acc);
	   				   System.out.println("Press 0 to stop & go to Selection Menu \n or any number to add more customers");
	   			 
	   			    s=sc.nextInt();
	                }while(s!=0);
		    
		   return empList;
	}	
	}


