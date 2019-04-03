package lab6;
/**
 * 
 * @author LOKE$H
 *
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
Exercise 6: Create a method to accept date and print the duration in days, months and years with 
regards to current system date.
*/
public class ex6 {

	static void duration(Date d)
	{
		
		long sec=d.getTime();
		Date c=new Date();
		long cur=c.getTime();
		long diff=Math.abs(sec-cur);
		long days=diff/(1000*60*60*24);
		System.out.println("days : "+days);
		long months=days/30;
		System.out.println("months : "+months);
		long years=months/12;
		System.out.println("years : "+years);
		
		
	}
	
	
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		System.out.println("enter date in dd/MM/yyyy");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date d=sdf.parse(str);
	  duration(d);
		
		
		

	}

}
