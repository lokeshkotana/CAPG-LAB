package Assessment;
/**
 * 
 * @author LOKE$H
 *
 */
import java.util.*;
public class prj2 {
	public static void main(String ars[])
	{
		List<String> list=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		int temp;
		while(true)
		{
			System.out.println("Sample Input and Output :\n1. Insert\n2. Search\n3. Delete\n4. Display\n5. Exit");
			System.out.println("Enter your choice :");
			temp=sc.nextInt();
			switch (temp) {
			case 1:
				System.out.println("Enter the item to be inserted:");
				String str=sc.next();
				
				list.add(str);
				System.out.println("Inserted successfully");
				break;
			case 2:
				System.out.println("Enter the item to search :");
				str=sc.next();
				if(list.contains(str))
				{
					System.out.println("Item found in the list.");
				}
				else
				{
					System.out.println("Item not found in the list.");
				}
				break;
			case 3:
				System.out.println("Enter the item to delete:");
				str=sc.next();
				if(list.contains(str))
				{
					list.remove(str);
					System.out.println("Deleted successfully");
				}
				else
				{
					System.out.println("Item does not exist..");
				}
				break;
			case 4:
				System.out.println("The Items in the list are:");
				for(String s:list)
				{
					System.out.println(s);
				}
				break;
			case 5:
				System.exit(0);
				break;
			}
		}
	}

}