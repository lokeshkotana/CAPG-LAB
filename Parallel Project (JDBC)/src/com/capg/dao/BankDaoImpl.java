package com.capg.dao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import com.capg.bean.*;
import com.capg.main.BankMain;
import com.capg.utility.BankConnection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BankDaoImpl implements BankDao
{
	Connection con=BankConnection.getonnection();
	
	
	
	@Override
	public String createAccount(long custid,String userid, String pwd, String repwd, String adrs, long phno,String fullname) {
		// TODO Auto-generated method stub
		
		
    	String res=" ";
    	try {
    		
    	/*	// creating table
			PreparedStatement ps=con.prepareStatement("create table bank (userid varchar(29) UNIQUE NOT NULL"+
			",pwd varchar(29) NOT NULL, ,adrs varchar(99) NOT NULL, phno int NOT NULL ,custid int PRIMARY KEY,"+
					"fullname varchar(49) NOT NULL , bal int NOT NULL,accno INT UNIQUE NOT NULL)");
			int x=ps.executeUpdate();
			if(x>0) {
				res="table bank created";
				*/
			
    		/*create table transaction (custid REFERENCES  bank(custid),type varchar(11) NOT NULL, amount int  NOT NULL,time varchar(200))
*/


    		PreparedStatement ps=con.prepareStatement("insert into bank values(?,?,?,?,?,?,?,?)");
				ps.setString(1,userid);
				ps.setString(2,pwd);
				ps.setString(3,adrs);
				ps.setLong(4,phno);
				BankMain bm=new BankMain();
				
				
				ps.setLong(5,custid);
				ps.setString(6,fullname);
				ps.setLong(7,0);
				ps.setLong(8,account());
				int x=ps.executeUpdate();
				if(x>0) {
					res="values inserted";
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("UseId already exist  ---  try new userId");
		return "Exception";
		}
    	
    	
    	
		String s=userid+"'s Account Created";
		return s;
	}
	
	
	@Override
	public String loginAccount(String userid, String pwd) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from bank where userid=?");
			stmt.setString(1, userid);
			ResultSet rs= stmt.executeQuery();
			rs.next();
	
			if(rs.getString("pwd").equals(pwd))
			{
			String s=Long.toString(rs.getLong("custid"));
			return s;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "UserId doesnot exist";
		}
		
            
        
				return "Wrong password";
	}
      
	@Override
	public long showBalance(long custid) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("select * from bank where custid=?");
            stmt.setLong(1, custid);
			ResultSet rs= stmt.executeQuery();
			rs.next();
			//String s=Long.toString(rs.getLong("bal"));
			return rs.getLong("BALANCE");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return -1;
	}

	@Override
	public String deposit(long custid,long amt) {
		// TODO Auto-generated method stub
		String res="";
		
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("update bank set balance=balance+? where custid=?");
			stmt.setLong(1, amt);
			stmt.setLong(2,custid);
			int y=stmt.executeUpdate();

			if(y>0) {
				res=amt+" deposited";
			}	
			
			PreparedStatement stmt2;
			stmt2 = con.prepareStatement("insert into transaction values(?,?,?,?)");
			stmt2.setLong(1,custid);
			stmt2.setLong(2,amt);
			
			
			String date=""+new Date();
			stmt2.setString(3,  date);
			stmt2.setString(4,"deposited");
			stmt2.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String withDraw(long custid,long amt) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt1;
			stmt1 = con.prepareStatement("select * from bank where custid=?");
			stmt1.setLong(1, custid);
			ResultSet rs= stmt1.executeQuery();
			rs.next();
			if(rs.getLong("balance")<amt)
			  {
				return "No Sufficeient Balance";
			  }
			else {
			PreparedStatement stmt;
			stmt = con.prepareStatement("update bank set balance=balance-? where custid=?");
			stmt.setLong(1,amt);
			stmt.setLong(2, custid);
			int y=stmt.executeUpdate();
			
			
			
			PreparedStatement stmt2;
			stmt2 = con.prepareStatement("insert into transaction values(?,?,?,?)");
			stmt2.setLong(1,custid);
			stmt2.setLong(2,amt);
			
			
			String date=""+new Date();
			stmt2.setString(3,  date);
			stmt2.setString(4,"withdraw");
			
			stmt2.executeUpdate();
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amt+" withdraw";
		

	}

	@Override
	public String fundTransfer(long custid,long amt,long otheracc) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt1;
		try {
			stmt1 = con.prepareStatement("select * from bank where custid="+custid);
			ResultSet rs= stmt1.executeQuery();
			rs.next();
			if(rs.getLong("balance")<amt)
			return "No Sufficeient Balance";
			
			
			PreparedStatement stmt = con.prepareStatement("update  bank set balance=balance-"+amt+"  where custid="+custid);
			stmt.executeUpdate();
			
			PreparedStatement stmt4 = con.prepareStatement("update  bank set balance=balance+"+amt+"  where accno="+otheracc);
			stmt4.executeUpdate();
			
			PreparedStatement stmt2;
			stmt2 = con.prepareStatement("insert into transaction values(?,?,?,?)");
			stmt2.setLong(1,custid);
			stmt2.setLong(2,amt);
			
			
			String date=""+new Date();
			stmt2.setString(3,  date);
			stmt2.setString(4,"Fund Transferred");
			stmt2.executeUpdate();
			return amt+"  transferred to Account no: "+otheracc;
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "sql exception";
		}
		
		
			
	}

	@Override
	public void printTransactions(long custid) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement stmt1;
		try {
			stmt1 = con.prepareStatement("select type,amount,time from transaction where custid="+custid);
			ResultSet rs= stmt1.executeQuery();
			String s;
			while(rs.next())
			{
				if(rs.getString(1).equals("deposited"))
					s="+";
				else
					s="-";
				System.out.println(rs.getString(1)+"  "+s+rs.getLong(2)+"  "+rs.getString(3));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public long account()
	{
		
		do
		{
			int f=1;
		long rand=(long) (Math.random()*(11505129999L-11505123100L+1))+11505123100L;
		PreparedStatement stmt4;
		try {
			stmt4 = con.prepareStatement("select * from bank");
			ResultSet rs= stmt4.executeQuery();
			while(rs.next())
			{
				if(rs.getLong("accno")==rand)
				{
					f=0;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if(f==1)
			  return rand;
		}while(true);
		
	}


	@Override
	public long showAccno(long custid) {
		// TODO Auto-generated method stub
		PreparedStatement stmt4;
		try {
			stmt4 = con.prepareStatement("select * from bank where custid="+custid);
			ResultSet rs= stmt4.executeQuery();
			rs.next();
			return rs.getLong("accno");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return -1;		
	}

	
	public long custidgen()
	{
		
		do
		{
			int f=1;
		long rand=(long) (Math.random()*(1155950L-1151050L+1))+1151050L;
		PreparedStatement stmt4;
		try {
			stmt4 = con.prepareStatement("select * from bank");
			ResultSet rs= stmt4.executeQuery();
			while(rs.next())
			{
				if(rs.getLong("accno")==rand)
				{
					f=0;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if(f==1)
			  return rand;
		}while(true);
		
	}

	

}

