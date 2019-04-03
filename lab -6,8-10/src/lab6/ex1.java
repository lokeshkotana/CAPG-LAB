package lab6;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 
 * @author LOKE$H
 *
 */
public class ex1 {
	
	public static void main(String args[])
	{
		//Scanner sc=new Scanner(System.in);
		String str="3 5 76 2 0 5 ";
		//str=sc.nextLine();
		int sum=0;
		StringTokenizer st=new StringTokenizer(str, " ");
		while(st.hasMoreTokens())
		{
			int x=Integer.parseInt(st.nextToken());
			System.out.println(x);
			sum=sum+x;
		}
		System.out.println("sum:"+sum);
	}
}