package Assessment;
/**
 * 
 * @author LOKE$H
 *
 */

import java.util.*;

class coll
{
	private String fn,ln,em,ad;
	private long  mn=9855123275L;
	public coll(String fn, String ln, String em, String ad, long mn) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.em = em;
		this.ad = ad;
		this.mn = mn;
	}
	public String getFn() {
		return fn;
	}
	
	public String getLn() {
		return ln;
	}
	
	public String getEm() {
		return em;
	}
	
	public String getAd() {
		return ad;
	}
	
	public long getMn() {
		return mn;
	}
	/*@Override
	public String toString() {
		return "coll [fn=" + fn + ", ln=" + ln + ", em=" + em + ", ad=" + ad + ", mn=" + mn + "]";
	}*/
	
	
	
	
}



class SortName implements Comparator<coll>{

	@Override
	public int compare(coll o1, coll o2) {
		// TODO Auto-generated method stub
		return o1.getFn().compareTo(o2.getFn());
	}	
}

public class prj1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Number of Employees");
		int n=sc.nextInt();
		//List<coll> li=new LinkedList<coll >();
		Set<coll> li=new TreeSet<coll >(new SortName());
		
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter Employee "+i+" Details:");
		System.out.println("Enter the Firstname");
	    String fn=sc.next();
		System.out.println("Enter the Lastname");
		String ln=sc.next();
		System.out.println("Enter the Mobile");
        long mn=sc.nextLong();
		System.out.println("Enter the Email");
		String em=sc.next();
		System.out.println("Enter the Address");
		String ad=sc.next();
		
        li.add(new coll(fn,ln,em,ad,mn));
		}
		System.out.println("Employee List:");
		
		
		System.out.format("%-15s %-15s %-15s %-30s %-15s\n","Firstname","Lastname","Mobile","Email","Address");
		//li.sort(new SortName());
		for(coll i:li)
		{
			System.out.format("%-15s %-15s %-15s %-30s %-15s\n",i.getFn(),i.getLn(),i.getMn(),i.getEm(),i.getAd());
		}

     
		
	}

}
