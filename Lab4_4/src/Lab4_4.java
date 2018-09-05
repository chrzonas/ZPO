import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lab4_4
{
	public static <T> void swap(List<T> list, int i, int j)
	{
		T elementI = list.get(i);
		T elementJ = list.get(j);
		list.set(i, elementJ);
		list.set(j, elementI);
	}
	
	public static <T> void swap2(List<T> list, int i, int j) throws NotificationException
	{
		if (list instanceof LinkedList)
		{
			throw new NotificationException();
		}
		
		T elementI = list.get(i);
		T elementJ = list.get(j);
		list.set(i, elementJ);
		list.set(j, elementI);
	}
	
	public static class NotificationException extends Exception
	{
		private static final long serialVersionUID = 1L;

		public NotificationException()
		{
			System.out.println("Brak obslugi swobodnego dostepu!");
		}
	}
	
	public static void main(String[] args)
	{
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Integer> list2 = new LinkedList<>();
		list2.add(4);
		list2.add(5);
		list2.add(6);

		List<Integer> list3 = new ArrayList<>();
		list3.add(1);
		list3.add(2);
		list3.add(3);

		List<Integer> list4 = new LinkedList<>();
		list4.add(4);
		list4.add(5);
		list4.add(6);

		System.out.println("--- Funkcja SWAP ---");
		System.out.println();
		
		System.out.println("Przed zamiana: ");
		System.out.println("ArrayList: " + list1);
		System.out.println("LinkedList: " + list2);
		swap(list1, 0, 2);
		swap(list2, 0, 2);
		System.out.println();
		System.out.println("Po zamianie: ");
		System.out.println("ArrayList: " + list1);
		System.out.println("LinkedList: " + list2);
		
		System.out.println();
		
		System.out.println("--- Funkcja SWAP2 ---");
		System.out.println();
		
		System.out.println("Przed zamiana: ");
		System.out.println("ArrayList: " + list3);
		System.out.println("LinkedList: " + list4);

		try
		{
			swap2(list3, 0, 2);
			swap2(list4, 0, 2);
			System.out.println();
			System.out.println("Po zamianie: ");
			System.out.println("ArrayList: " + list3);
			System.out.println("LinkedList: " + list4);
			
		}
		catch (NotificationException NotificationException)
		{
			NotificationException.printStackTrace();
		}

	}



	

	
}