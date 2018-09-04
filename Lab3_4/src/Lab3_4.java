import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ComparisonChain;

public class Lab3_4
{

	public static void main(String[] args)
	{
		Student s1 = new Student("Paweł", "Ziobro", "12.05.1991", 160);
		Student s2 = new Student("Paweł", "Kowalski", "24.10.1982", 175);
		Student s3 = new Student("Paweł", "Nowakowski", "12.05.1992", 180);
		Student s4 = new Student("Paweł", "Baranowski", "24.10.1992", 174);
		Student s5 = new Student("Paweł", "Nowak", "12.05.1990", 160);
		Student s6 = new Student("Paweł", "Resztek", "24.10.1990", 175);

		List<Student> listStudents = new ArrayList<>();
		listStudents.add(s1);
		listStudents.add(s2);
		listStudents.add(s3);
		listStudents.add(s4);
		listStudents.add(s5);
		listStudents.add(s6);

		List<Student> listStudents2 = new ArrayList<>(listStudents);

		System.out.println("--- Przed sortowaniem JDK ---");
		System.out.println();
		
		for (Student student : listStudents)
		{
			System.out.println(student);
		}

		Collections.sort(listStudents, (Student o1, Student o2) ->
		{
			Integer year1 = o1.getYear();
			Integer year2 = o2.getYear();
			int compareYear = year1.compareTo(year2);
			
			if (compareYear != 0)
			{
				return compareYear;
			}

			String letter1 = o1.getFirstLetterSurname();
			String letter2 = o2.getFirstLetterSurname();
			int compareFirstLetter = letter1.compareTo(letter2);
			
			if (compareFirstLetter != 0)
			{
				return compareFirstLetter;
			}
			
			int compareGrowth = o2.getGrowth() - o1.getGrowth();
			
			return compareGrowth;
		});

		System.out.println();
		System.out.println("--- Po sortowaniu JDK ---");
		System.out.println();
		
		for (Student student : listStudents)
		{
			System.out.println(student);
		}

		System.out.println();
		System.out.println("--- Przed sortowaniem Guava ---");
		System.out.println("");
		
		for (Student student : listStudents2)
		{
			System.out.println(student);
		}

		Collections.sort(listStudents2, (Student o1, Student o2) ->
		{
			return ComparisonChain.start().compare(o1.getYear(), o2.getYear()).compare(o1.getFirstLetterSurname(), o2.getFirstLetterSurname()).compare(o2.getGrowth(), o1.getGrowth()).result();
		});

		System.out.println();
		System.out.println("--- Po sortowaniu Guava ---");
		System.out.println();
		
		for (Student student : listStudents2)
		{
			System.out.println(student);
		}
	}

}