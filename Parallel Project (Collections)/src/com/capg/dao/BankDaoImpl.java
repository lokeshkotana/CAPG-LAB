package com.capg.dao;
import java.util.*;


import com.capg.bean.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BankDaoImpl implements BankDao
{
	List<Bank>lic=new ArrayList();
	
	List<Transaction>lit=new ArrayList();
	Transaction t;
	Map<String,String> m=new HashMap();
   Bank b;
	@Override
	public String createAccount(String userid, String pwd, String repwd, String adrs, long phno,long custid,String fullname) {
		// TODO Auto-generated method stub
		b=new Bank();
		
		if(m.containsKey(userid))
			return "UserID already exist \nEnter other UserID";
	   b.setUserid(userid);
	   b.setPwd(pwd);
	   b.setRepwd(repwd);
	   b.setAdrs(adrs);
	   b.setFullname(fullname);
	   b.setPhno(phno);
	   
	  
	   b.setCustid(custid);
	   b.setBal(0);
	   
	   
	   b.setAccno( random()  );
	   
	   
	   
	   m.put(userid, pwd);
	   
	   lic.add(b);
	 
		String s=userid+"'s Account Created";
		return s;
	}
	
	
	@Override
	public String loginAccount(String userid, String pwd) {
		// TODO Auto-generated method stub
		
		if(m.containsKey(userid))
		{
		if(m.get(userid).equals(pwd))
            {
			long custid = 0;
			for(Bank i:lic)
			{
				if(i.getUserid().equals(userid))
				{
					custid=i.getCustid();
					break;
				}
			}
			String s=Long.toString(custid);
			return s;
            }
        else
             return "Wrong password";    	
		}
				return "UserID doesnot exist";
	}
      
	@Override
	public long showBalance(long custid) {
		// TODO Auto-generated method stub
		for(Bank i:lic)
		{
			if(i.getCustid()==custid)
			{
				return i.getBal();
				
			}
		}
		return -1;
	}

	@Override
	public String deposit(long custid,long amt) {
		// TODO Auto-generated method stub
		for(Bank i:lic)
		{
			if(i.getCustid()==custid)
			{
				{
				Date d=new Date();
				t=new Transaction();
				t.setD(d);
				t.setAmt(amt);
				t.setCustid(custid);
				t.setCh("deposited");
				lit.add(t);
				}
				i.setBal(amt+i.getBal());
				return amt+" deposited";
				
			}
		}
		return "Invalid CustID";
	}

	@Override
	public String withDraw(long custid,long amt) {
		// TODO Auto-generated method stub
		for(Bank i:lic)
		{
			if(i.getCustid()==custid)
			{
				if(i.getBal()<amt)
				return "No Sufficeient Balance";
		       
				i.setBal(i.getBal()-amt);
				{
					t=new Transaction();
					Date d=new Date();
					t.setD(d);
					t.setAmt(amt);
					t.setCustid(custid);
					t.setCh("WithDraw");
					lit.add(t);
				}
				return amt+" WithDraw";
				
			}
		}
		return "Invalid CustID";
	}

	@Override
	public String fundTransfer(long custid,long amt,long otheracc) {
		// TODO Auto-generated method stub
		int fg=0;
		for(Bank i:lic)
		{
			if(i.getCustid()==custid)
			{
				fg=1;
				if(i.getBal()<amt)
					return "No Sufficeient Balance";
			

				i.setBal(i.getBal()-amt);
				break;
			}
			
		}
		if(fg==0)
			return "Invalid CustID";
		int j,f=0;
		for(j=0;j<lic.size();j++)
		{
			if(lic.get(j).getAccno()==otheracc)
			{
				lic.get(j).setBal(lic.get(j).getBal()+amt);
				f=1;
				break;
			}
		}
		{
			t=new Transaction();
			Date d=new Date();
			t.setD(d);
			t.setAmt(amt);
			t.setCustid(custid);
			t.setCh("Fund Transferred");
			lit.add(t);
			}
		if(f==0)
		{
			return amt+"  transferred to Account no: "+otheracc;
		}
		
		return amt+"  transferred to "+lic.get(j).getUserid() +"Account no:"+otheracc;
	}

	@Override
	public void printTransactions(long custid) {
		// TODO Auto-generated method stub
		int f=0;
		char c;
		for(Transaction i:lit)
		{
			if(i.getCustid()==custid)
			{
				f=1;
				if(i.getCh().equals("deposited"))
					c='+';
				else
					c='-';
				System.out.println(i.getD()+"  "+c+i.getAmt()+"  "+i.getCh());
				
			}
		}
		if(f==0)
			System.out.println("No Transactions happened");
		
	}

	
	public long random()
	{
		int f;
		do
		{
		long rand=(long) (Math.random()*(11505123999L-11505123100L+1))+11505123100L;
		 f=0;
		  
		for(Bank i:lic)
		   {
			   if(i.getAccno()==rand)
			   {
				   f=1;
				   break;
			   }
		   }
		if(f==0)
			return rand;
		}  while(f==1);
		return 0;
	}


	@Override
	public long showAccno(long custid) {
		// TODO Auto-generated method stub
		for(Bank i:lic)
		{
			if(i.getCustid()==custid)
			{
				return i.getAccno();
				
			}
		}
		return -1;
	}

	

}

