package lab6;
import java.io.*;
/**
 * 
 * @author LOKE$H
 *
 */
/*Exercise 3: Write a Java program that displays the number of characters, lines and words in a
text? 
*/
	import java.util.*;	
		public class ex3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
      
		FileReader fr=new FileReader("C:\\Users\\LOKE$H\\Documents\\download movies.txt");
		int ch=0;
		while(fr.read()!=-1)
		{
			ch++;
		}
		System.out.println("number of characters are "+ch);
		
		
		FileReader fr2=new FileReader("C:\\Users\\LOKE$H\\Documents\\download movies.txt");
	BufferedReader br=new BufferedReader(fr2);
	int l=0;
	while(br.readLine()!=null)
	{
		l++;
	}
	System.out.println("number of lines are "+l);

	
	File f=new File("C:\\Users\\LOKE$H\\Documents\\download movies.txt");
	FileReader fr3=new FileReader(f);
	BufferedReader br3=new BufferedReader(fr3);
	String str="";
	int s=0;
	while((str=br3.readLine())!=null) {
		
		StringTokenizer st=new StringTokenizer(str," ");
		
	   while(st.hasMoreTokens())
	   {
		  // System.out.println(st.nextToken());
		  st.nextToken();
		   s++;
		   
	   }
	
	}
	
	System.out.println("number of words are "+s);

	}

}
