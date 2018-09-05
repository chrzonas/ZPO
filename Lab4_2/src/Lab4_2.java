import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

public class Lab4_2
{
	public static void replace(List<String> list)
	{
		ListIterator<String> it = list.listIterator();
		
		while (it.hasNext())
		{
			int i = it.nextIndex();
			String element = it.next();
			list.set(i, element.toUpperCase());
		}
	}

	public static void replace2(List<String> list)
	{
		int i = 0;
		
		for (i = 0 ; i < list.size() ; i++)
		{
			String element = list.get(i);
			element = element.toUpperCase();
			list.set(i, element);
		}
	}

	public static void replace3(List<String> list)
	{
		int i = 0;
		
		for (i = 0 ; i < list.size() ; i++)
		{
			UnaryOperator<String> unary = s -> s.toUpperCase();
			list.replaceAll(unary);
		}
	}

	public static void show(List<String> list)
	{
		list.forEach(x -> System.out.println(x));
	}
	
	public static void main(String[] args)
	{
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		List<String> list2 = Arrays.asList("aaa", "bbb", "ccc");
		List<String> list3 = Arrays.asList("aaa", "bbb", "ccc");

		System.out.println("--- Iterator ---");
		show(list);
		System.out.println();
		replace(list);
		show(list);
		
		System.out.println();
		
		System.out.println("--- Petla ---");
		show(list2);
		System.out.println();
		replace2(list2);
		show(list2);
		
		System.out.println();
		
		System.out.println("--- replaceAll ---");
		show(list3);
		System.out.println();
		replace3(list3);
		show(list3);
	}
}