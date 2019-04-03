package com.capg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.service.BankService;
import com.capg.service.BankServiceImpl;

/**
 * 
 * @author LOKE$H
 *
 */

class BankTest {
	
	static BankService bs;
   @BeforeAll
	public static void init()
	{
		bs=new BankServiceImpl();
	}
	
  
	@Test
	void test() {
		assertEquals("Lokesh's Account Created",bs.createAccount("Lokesh","loki","loki", "Vizag", 9855123275L,11005,"Lokesh Kotana"));
	}
	
	@Test
	void test1() {
		assertEquals("ramesh's Account Created",bs.createAccount("ramesh","ramu","ramu", "Vizag", 9855123275L,11001,"Ramesh Babu"));
	}
	
	@Test
	void test2() {
		assertEquals("Must enter Full Name",bs.createAccount("ramu","ramu","ramu", "Vizag", 9855123275L,11001,""));
	}
	@Test
	void test3() {
		assertEquals("UserID must be length >=4",bs.createAccount("ram","ramu","ramu", "Vizag", 9855123275L,11001,"Ramesh Babu"));
	}
	@Test
	void test4() {
		assertEquals("Password must be length >=4",bs.createAccount("ramu","ram","ram", "Vizag", 9855123275L,11001,"Ramesh Babu"));
	}
	@Test
	void test5() {
		assertEquals("Mobile number must be 10 digits",bs.createAccount("ramu","ramu","ramu", "Vizag", 855123275L,11001,"Ramesh Babu"));
	}
	@Test
	void test6() {
		assertEquals("Password doesn't match",bs.createAccount("ramu","ramu","rama", "Vizag", 9855123275L,11001,"Ramesh Babu"));
	}

	
	@Test
	void test7() {
		assertEquals("UserID doesnot exist",bs.loginAccount("mesh", "ramu"));
	}
    
	@Test
	void test8() {
		assertEquals("200 deposited",bs.deposit(11001, 200));
	}
	
	@Test
	void test9() {
		assertEquals("Invalid amount",bs.deposit(11001, 0));
	}
	@Test
	void test10() {
		assertEquals("Invalid amount",bs.withDraw(11001,-90));
	}
	
}






