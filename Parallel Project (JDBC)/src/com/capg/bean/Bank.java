package com.capg.bean;
import java.util.*;
public class Bank {
private String userid,pwd,repwd,fullname;
private String adrs;
private long phno,custid,bal,accno;

public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}

public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getRepwd() {
	return repwd;
}
public void setRepwd(String repwd) {
	this.repwd = repwd;
}
public String getAdrs() {
	return adrs;
}
public void setAdrs(String adrs) {
	this.adrs = adrs;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}
public long getCustid() {
	return custid;
}
public void setCustid(long custid) {
	this.custid = custid;
}


public long getBal() {
	return bal;
}
public void setBal(long bal) {
	this.bal = bal;
}
public long getAccno() {
	return accno;
}
public void setAccno(long accno) {
	this.accno = accno;
}

@Override
public String toString() {
	return "Bank [userid=" + userid + ", pwd=" + pwd + ", repwd=" + repwd + ", adrs=" + adrs + ", phno=" + phno
			+ ", custid=" + custid + "]";
}




}
