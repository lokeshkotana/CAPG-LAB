package lab9;
/**
 * @author LOKE$H
 */
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ex1 implements Runnable {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
				ExecutorService es=Executors.newFixedThreadPool(3);
			ex1 e= new ex1();
			for(int i=0;i<8;i++)
			{
				Thread t=new Thread(e);
				t.start();
				es.execute(e);
			}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread()+" is running");
	}

}
