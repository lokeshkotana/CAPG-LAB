package com.capg.service;

import java.util.List;

//import com.capg.bean.Bank;

public interface BankService {

public String createAccount(long custid,String userid,String pwd,String repwd,String adrs,long phno,String fullname);
public String loginAccount(String userid,String pwd);


public String showBalance(long custid);
public String deposit(long custid,long amt);
public String withDraw(long custid,long amt);
public String fundTransfer(long custid,long amt,long otheracc);
public long showAccno(long custid);
public void printTransactions(long custid);


}


