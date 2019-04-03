/*Exercise 7: You are asked to create an application for registering the details of jobseeker. 
The requirement is: Username should always end with _job and there should be at least minimum of 8 
characters to the left of _job. Write a function to validate the same. Return true in case the
validation is passed. In case of validation failure return false.

	*/	
	/**
 * 
 * @author LOKE$H
 *
 */	
package lab6;
/**
 * 
 * @author LOKE$H
 *
 */
import java.util.Scanner;

class Name
{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		if(name.lastIndexOf("_job")!=-1  && name.lastIndexOf("_job")==name.length()-4 && name.length()==12  )
		{
			this.name = name;	
		}
		else
		   System.out.println("Invalid name");
		
		
	}
	
	
}

public class ex7
{
	
	public static void main(String ew[])
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the username");
		String s=sc.next();
		Name e=new Name();
		
		e.setName(s);
		System.out.println(e.getName());
		
		
	}
	
}