package lab6;
/**
 * 
 * @author LOKE$H
 *
 */
/*Exercise 4: Write a Java program that reads on file name from the user, then displays information
about whether the file exists, whether the file is readable, whether the file is writable, the
type of file and the length of the file in bytes?
		*/

import java.io.*;
import java.util.*;

public class ex4
{
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	String file=sc.nextLine();
   File f=new File(file);
   if(f.exists())
   {
	   System.out.println(" Exists");
	   
	   
	   if(f.isFile())
	   {
		   System.out.println("it is a file");
	     
		   String fn=f.getName();
		   if(fn.lastIndexOf('.')!=0 && fn.lastIndexOf('.')!=-1)
		   {
			   System.out.println("file type is "+fn.substring(fn.lastIndexOf('.')));
		   }
		   
		   
		   
		   
		   
		   
	   }
	   if(f.isDirectory())
		   System.out.println("it is directory");
	   
	   
	   
	   if(f.canRead())
	   {
		   System.out.println("Readable");
	   }
	   else
	   {
		   System.out.println("Not Readable");   
	   }
	   
	   if(f.canWrite())
	   {
		   System.out.println("Writable");
	   }
	   else
	   {
		   System.out.println("Not Writable");   
	   }
	   
	   
	   System.out.println("length of the file is "+f.length()+" bytes");
	   
   }
   else
   {
	   System.out.println("doesnot exist");   
   }
   
  
   
	
}

}








