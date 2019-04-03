package lab10;
/**
 * 
 * @author LOKE$H
 *
 */
interface Power
{
	String insp(String str);
}
public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Power i=(str)->{
			
			StringBuilder sb=new StringBuilder();
			sb.append(str.charAt(0));
			for(int  j=1;j<str.length();j++)
			{
				sb.append(" ");
				sb.append(str.charAt(j));
			}
			return sb.toString();
			
		};
	
	System.out.println(i.insp("lokesh"));
	
	}

}
