package lab6;

import java.io.*;
/**
 * 
 * @author LOKE$H
 *
 */
/*
Exercise 2: Write a Java program that reads a file and displays the file on the screen, with a 
line number before each line?
*/
		
		public class ex2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileReader fr=new FileReader("C:\\Users\\LOKE$H\\Documents\\download movies.txt");
		BufferedReader br=new BufferedReader(fr);
		
		int c=0;
		String str="";
		while((str=br.readLine())!=null)
		{
			
			System.out.println(++c + " " + str);
			
		}
		fr.close();
		
		
		
		
		
		

	}

}
