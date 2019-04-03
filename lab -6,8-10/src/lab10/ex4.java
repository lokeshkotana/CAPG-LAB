package lab10;
/**
 * 
 * @author LOKE$H
 *
 */
interface Met
{
	void set(String str);
	
	
}
interface Met2
{
	String get();
}
public class ex4 {

	 String str1;
	 void set2(String str)
	{
		str1=str;
	}
	String get2()
	{
		return str1;
	}
	public static void main(String[] args) {
	
		ex4 o=new ex4();
		
		Met m=o::set2;
		m.set("lokesh");
		Met2 m2=o::get2;
		System.out.println(m2.get());
	
	}

}
