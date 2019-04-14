
package com.capg.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capg.dao.BankDaoImpl;
import com.capg.service.BankServiceImpl;

public class BankMain {

	public static void main(String args[])
	{
		
		BankServiceImpl bs=new BankServiceImpl();
		BankDaoImpl bd=new BankDaoImpl();
//  if we keep this in while loop, every time new object created and previous
//  data is erased
	
	 while(true)
	{
		
		System.out.println("1 Create Bank Account");
		System.out.println("2 Login Bank Account");
		System.out.println("0 Exit");
		
		Scanner sc=new Scanner(System.in);
		int c;
		try {
		 c=sc.nextInt();
		}catch(InputMismatchException e)
		   {
			   System.out.println("Only numbers are allowed");
			   continue;
		   }
		 
	//String userid, String pwd, String repwd, String adrs, long phno,long custid	
		switch(c)
		{
			case 1:
				System.out.println("Enter Full Name");
				String fullname=sc.nextLine();
				 fullname=sc.nextLine();
				 System.out.println("Enter Mobile number(10 digits)");
					long phno;
					try {
					phno=sc.nextLong();
					} catch(InputMismatchException e)
					   {
						   System.out.println("Phno should must be in digits");
						   continue;
					   }
				System.out.println("Enter UserID(atleast 4 characters)");
				String userid=sc.next();
				System.out.println("Enter Password(ateast 4 characters)");
				String pwd=sc.next();
				System.out.println("Re-enter Password");
				String repwd=sc.next();
				System.out.println("Enter Address");
				String adr=sc.next();
				
				long custid=bd.custidgen();
			String str=bs.createAccount(custid,userid,pwd ,repwd , adr,phno ,fullname);
			
			System.out.println(str);
				if(!str.contains("Create"))
				{continue;
				}
				
		in: while(true)
		 {
			System.out.println("********WELCOME***********");
			System.out.println("Full Name    : "+fullname);
			System.out.println("UserID       : "+userid);
			
			System.out.println("CustID       : "+custid);
			System.out.println("Account no   : "+bs.showAccno(custid));
			System.out.println("*************************");
				System.out.println("1 Deposit");
				System.out.println("2 WithDraw");
				System.out.println("3 Fund Transfer");
				System.out.println("4 Show Balance");
				System.out.println("5 Print Transactions");
				System.out.println("6 Logout");
				System.out.println("0 Exit");
				String c2;
				int c1;
				try {
				 c2=sc.next();
				 c1 = Integer.parseInt(c2);
				}catch(InputMismatchException | NumberFormatException s1)
				   {
					   System.out.println("Only numbers are allowed");
					   continue;
				   }
				switch(c1)
				{
				case 1:
					System.out.println("Enter amount to be deposited");
					long d;
					try {
					 d=sc.nextLong();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Only numbers are allowed");
						   continue;
					}
					System.out.println(bs.deposit(custid,d));
					System.out.println("Balance : "+bs.showBalance(custid));
					break;
	            case 2:
	            	System.out.println("Enter amount to WithDraw");
	            	long w;
					try {
					 w=sc.nextLong();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Only numbers are allowed");
						   continue;
					}
					System.out.println(bs.withDraw(custid,w));
					System.out.println("Balance : "+bs.showBalance(custid));
					break;
	            case 3:
	            	System.out.println("Enter Account number to Transfer");
	            	long acc;
					try {
					 acc=sc.nextLong();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Only numbers are allowed");
						   continue;
					}
					System.out.println("Enter amount to Transfer");
					long f;
					try {
					 f=sc.nextLong();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Only numbers are allowed");
						   continue;
					}
		            System.out.println(bs.fundTransfer(custid,f,acc));
		            System.out.println("Balance : "+bs.showBalance(custid));
		            break;
				
	            case 4:
	            	System.out.println("Balance : "+bs.showBalance(custid));
	            	break;
	            case 5:
	            	bs.printTransactions(custid);
	            	System.out.println("Balance : "+bs.showBalance(custid));
	            	break;
	            
	            case 6:
					
					break in;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid");
			
				}
		 }
				
				break;
				
				
			case 2:
				
				
				System.out.println("Enter UserID");
				String userid1=sc.next();
				System.out.println("Enter Password");
				String pwd1=sc.next();
				
				
				String s=bs.loginAccount(userid1,pwd1);
				
				if(s.equals("Wrong password"))
					System.out.println(s);
				else
				if(s.equals("UserId doesnot exist"))
					System.out.println(s);
				else 
				{
			
				long custid1=Long.parseLong(s);
				System.out.println("Successfully logged in");
			in: while(true)
			{
				
				System.out.println("********WELCOME***********");
				System.out.println("UserID       : "+userid1);
				System.out.println("CustID       : "+custid1);
				System.out.println("Account no   : "+bs.showAccno(custid1));
				System.out.println("1 Deposit");
				System.out.println("2 WithDraw");
				System.out.println("3 Fund Transfer");
				System.out.println("4 Show Balance");
				System.out.println("5 Print Transactions");
				System.out.println("6 Logout");
				System.out.println("0 Exit");
				String c3;
				int c2;
				try {
				 c3=sc.next();
				 c2 = Integer.parseInt(c3);
				}catch(InputMismatchException | NumberFormatException s1)
				   {
					   System.out.println("Only numbers are allowed");
					   continue;
				   }
				switch(c2)
				{
				case 1:
					System.out.println("Enter amount to be deposited");
					long d;
					try {
					 d=sc.nextLong();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Only numbers are allowed");
						   continue;
					}
					System.out.println(bs.deposit(custid1,d));
					System.out.println("Balance : "+bs.showBalance(custid1));
					break;
	            case 2:
	            	System.out.println("Enter amount to WithDraw");
	            	long w;
					try {
					 w=sc.nextLong();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Only numbers are allowed");
						   continue;
					}
					System.out.println(bs.withDraw(custid1,w));
					System.out.println("Balance : "+bs.showBalance(custid1));
					break;
	            case 3:
	            	System.out.println("Enter Account number to Transfer");
	            	long acc;
					try {
					 acc=sc.nextLong();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Only numbers are allowed");
						   continue;
					}
					System.out.println("Enter amount to Transfer");
					long f;
					try {
					 f=sc.nextLong();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Only numbers are allowed");
						   continue;
					}
		            System.out.println(bs.fundTransfer(custid1,f,acc));
		            System.out.println("Balance : "+bs.showBalance(custid1));
		            break;
				
	            case 4:
	            	System.out.println("Balance : "+bs.showBalance(custid1));
	            	break;
	            case 5:
	            	bs.printTransactions(custid1);
	            	System.out.println("Balance : "+bs.showBalance(custid1));
	            	
	            	break;
	            
	            case 6:
					
					break in;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid");
			
				}
				
			}
				}
				
				
				
				
				
				break;
			
			
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid ");

		
		
		}	
		
		}
		
	
		
	}


}






