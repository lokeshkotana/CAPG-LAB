package lab10;

/**
 * 
 * @author LOKE$H
 *
 */
interface Factorial
{
	long fact(int num);
}
public class ex5 {

	static long fact2(int num) {
		long f=1;
		for(int i=1;i<=num;i++)
		{
			f=f*i;
			}
		return f;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Factorial i=ex5::fact2;
		System.out.println(i.fact(5));
		
		
	}

}
