package Assessment;
/**
 * 
 * @author LOKE$H
 *
 */
import java.util.*;
 class Cards {
	
	private String key;
	private Integer value;
	public Cards(String key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Cards() {
		super();
	}
	@Override
	public String toString() {
		return "Cards [key=" + key + ", value=" + value + "\n]";
	}
	@Override
	public int hashCode() {
		return value;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cards && this.key.equals(((Cards) obj).key) && this.value==((Cards)obj).value)
			return true;
		return false;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
}


public class prj4 {
	
	public static void main(String args[])
	{
		Map<Cards,Integer> m=new HashMap<Cards, Integer>();
		int n;
		System.out.println("Enter the no of Card");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int i=1;
		Cards cards;
		while(n!=0)
		{
			
			System.out.println("Enter the Card "+i);
			String key=sc.next();
			Integer value=sc.nextInt();
			cards=new Cards(key,value);
			m.put(cards, i);
			i++;
			n--;
		}
		//Distinct Symbols
		Set<Cards> distinct = new TreeSet<Cards>();
		distinct=m.keySet();
		Set<String> cardKey=new TreeSet<String>();
		for(Cards c:distinct)
		{
			Cards c1=c;
			cardKey.add(c1.getKey());
		}
		System.out.println("Unique Cards are:"+cardKey);
		
		for(String str:cardKey)
		{
			i=0;
			n=0;
			System.out.println("Cards in "+ str +" Symbol");
			for(Cards c:distinct)
			{
				
				if(c.getKey().contains(str))
				{
					System.out.println(c);
					i++;
					n=c.getValue()+n;
				}
				
			}
			System.out.println("Number of cards :"+i);
			System.out.println("Sum of Numbers :"+n);
		}
	}
}
