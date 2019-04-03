package Assessment;
/**
 * 
 * @author LOKE$H
 *
 */
import java.util.*;
public class prj3 {
	public static void main(String args[])
	{
		System.out.println("Enter No of cards");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		Map<String,Integer> m=new TreeMap<String,Integer>();
		
		while(n-- !=0)
		{
			System.out.println("Enter a Card");
			String key=sc.next();
			Integer value=sc.nextInt();
			if(!m.containsKey(key))
			{
				m.put(key,value);
			}
		
		}
		System.out.println("Cards in Set are :");
		System.out.println(m);
	}
}