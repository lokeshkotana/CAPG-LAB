package lab6;
/**
 * 
 * @author LOKE$H
 *
 */

/*Exercise 5: Create a method that accepts a String and checks if it is a positive string. A string is considered a 
positive string, if on moving from left to right each character in the String comes after the previous characters
in the Alphabetical order. For Example: ANT is a positive String (Since T comes after N and N comes after A). 
The method should return true if the entered string is positive
*/
import java.util.*;




public class ex5 {

static int check(String st)
{
	
	for(int i=0;i<st.length()-1;i++)
	{
	if(st.charAt(i)>=st.charAt(i+1))
	{
		return 1;
	}
		
	}
	return 0;
	
}
	
	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
		System.out.println("enter the string");
		String st=sc.next();
	
		System.out.println((check(st)==1)?"Not positive string":"Positive string");
		
	}

}
