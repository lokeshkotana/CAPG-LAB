//Lab 8: Multithreading

/*Exercise 1: Write a program to do the following operations using Thread:
•	Create an user defined Thread class called as “CopyDataThread .java” .
•	This class will be designed to copy the content from one file “source.txt ” to another file 
    “target.txt” and after every 10 characters copied,   “10 characters are copied” message  will
    be shown to user.(Keep delay of 5 seconds after every 10 characters  read.)
•	Create another class “FileProgram.java” which will create above thread. Pass required File
    Stream classes to  CopyDataThread constructor and implement the above functionality.
*/
package lab8;
/**
 * 
 * @author LOKE$H
 *
 */
import java.io.*;

//FileProgram.java
public class ex1 extends Thread {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		CopyDataThread cdt=new CopyDataThread(new File("C:\\\\Users\\\\LOKE$H\\\\Documents\\\\download movies.txt"),new File("C:\\\\Users\\\\LOKE$H\\\\Documents\\\\download movies.txt"));
		Thread t=new Thread(cdt);
		
	}

}
