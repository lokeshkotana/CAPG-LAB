package lab10;
/**
 * 
 * @author LOKE$H
 *
 */
interface user
{
	boolean id(String user,String pwd);
	
}
public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String a="lok",b="sup";
	     user i=(x,y)->(x.equals(a)&&y.equals(b));

		System.out.println(i.id("lok", "sup"));
	}

}
