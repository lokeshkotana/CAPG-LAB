package lab10;
/**
 * 
 * @author LOKE$H
 *
 */
interface MyInterface
{
	double pow(int x,int y);
}
public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyInterface i=(x,y)->Math.pow(x, y);
		System.out.println(i.pow(3, 4));
	}

}
