package com.capg.bean;
import java.util.*;
public class Transaction {

	
	private Date d;
	private long amt;
	private String ch;
	private long custid;
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public long getAmt() {
		return amt;
	}
	public void setAmt(long amt) {
		this.amt = amt;
	}
	public String getCh() {
		return ch;
	}
	public void setCh(String ch) {
		this.ch = ch;
	}
	public long getCustid() {
		return custid;
	}
	public void setCustid(long custid) {
		this.custid = custid;
	}

	
	
}
