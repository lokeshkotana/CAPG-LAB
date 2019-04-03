package lab8;
import java.io.*;
/**
 * 
 * @author LOKE$H
 *
 */
public class CopyDataThread extends Thread{

	File f1,f2;
	public CopyDataThread(File f, File f1) {
		// TODO Auto-generated constructor stub
		this.f1=f1;
		this.f2=f2;
	}
	
	public void run()
	{
		try {
			FileReader fr=new FileReader(f1);
			FileWriter fw=new FileWriter(f2,true);
			
			
			
			int a;
			int count=0;
			int temp=0;
			while((a=fr.read())!=-1)
			{
				fw.write(a);
				count++;
				fw.flush();
				temp++;
				if(count==10)
				{
					System.out.println("10 char  are transferred");
					Thread.sleep(5000);
					count=0;
				}
			}
			System.out.println(temp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
}
