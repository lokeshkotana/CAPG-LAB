package com.capg.service;

import java.util.InputMismatchException;
import java.util.List;

import com.capg.dao.BankDaoImpl;
import com.capg.bean.Bank;

public class BankServiceImpl implements BankService
{
	
BankDaoImpl bd=new BankDaoImpl();
	@Override
	
	public String createAccount(String userid, String pwd, String repwd, String adrs, long phno, long custid,String fullname) {
		// TODO Auto-generated method stub
		if(fullname.length()==0)
			return "Must enter Full Name";
		if(phno<1000000000L || phno>9999999999L)
			return "Mobile number must be 10 digits";
		
		if(userid.length()<4) 
			return "UserID must be length >=4";
		if(pwd.length()<4 ) 
			return "Password must be length >=4";
		
		if(!pwd.equals(repwd))
			return "Password doesn't match";
		
		try {
		return bd.createAccount(userid, pwd, repwd, adrs, phno, custid,fullname);
		}
		catch(InputMismatchException e)
		{
			return "Mobile number must be in numbers";
		}
	}
	 
	
	
	@Override
	public String showBalance(long custid) {
		// TODO Auto-generated method stub
		if(bd.showBalance(custid)==-1)
			return "Invalid CustID";
		String s=Long.toString(bd.showBalance(custid));
		return s;
	}

	@Override
	public String deposit(long custid,long amt) {
		// TODO Auto-generated method stub
		if(amt<=0)
		{
			return "Invalid amount";
		}
		
		return bd.deposit(custid, amt);
	}

	@Override
	public String withDraw(long custid,long amt) {
		// TODO Auto-generated method stub
		if(amt<=0)
		{
			return "Invalid amount";
		}
		return bd.withDraw(custid, amt);
	}

	@Override
	public String fundTransfer(long custid,long amt,long otheracc) {
		// TODO Auto-generated method stub
		if(otheracc<=0)
		{
			return "Invalid account number";
		}
		if(amt<=0)
		{
			return "Invalid amount";
		}
		return bd.fundTransfer(custid, amt,otheracc);
	}

	@Override
	public void printTransactions(long custid) {
		// TODO Auto-generated method stub
		 bd.printTransactions(custid);
	}
	


	@Override
	public String loginAccount(String userid, String pwd) {
		// TODO Auto-generated method stub
		return bd.loginAccount(userid, pwd);
	}

	@Override
	public long showAccno(long custid) {
		// TODO Auto-generated method stub
		
		return bd.showAccno(custid);
	}
	
}
