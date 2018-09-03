import java.util.Scanner;

public class Lab1_4
{
	public static void funkcja(int dlugosc)
	{
		int a = 0;
		
		for (a = 0 ; a <= dlugosc ; a++)
		{
			System.out.print(a + "               ");
		}
	
		a = 0;
		System.out.println("");

		for (a = 0 ; a <= dlugosc ; a++)
		{
			if (a == dlugosc)
			{
				System.out.print("|");
			}
			else
			{
				System.out.print("                ");
			}
		}
		
		a = 0;
		System.out.println("");
		
		for (a = 0 ; a <= dlugosc ; a++)
		{
			if (a == dlugosc)
			{
				System.out.print("|");
			}
			else
			{
				System.out.print("|               ");
			}
		}
		
		a = 0;
		System.out.println("");
		
		for (a = 0 ; a <= dlugosc ; a++)
		{
			if (a == dlugosc)
			{
				System.out.print("|");
			}
			else
			{
				System.out.print("|       |       ");
			}
		}
		
		a = 0;
		System.out.println("");
		
		for (a = 0 ; a <= dlugosc ; a++)
		{
			if (a == dlugosc)
			{
				System.out.print("|");
			}
			else
			{
				System.out.print("|   |   |   |   ");
			}
		}
		
		a = 0;
		System.out.println("");
		
		for (a = 0 ; a <= dlugosc ; a++)
		{
			if (a == dlugosc)
			{
				System.out.print("|");
			}
			else
			{
				System.out.print("| | | | | | | | ");
			}
		}
		
		a = 0;
		System.out.println("");
		
		for (a = 0 ; a <= dlugosc ; a++)
		{
			if (a == dlugosc)
			{
				System.out.print("|");
			}
			else
			{
				System.out.print("||||||||||||||||");
			}
		}
	}

	public static void main(String[] args)
	{
		int dlugosc;
		Scanner odczyt = new Scanner(System.in);
		System.out.print("Podaj d³ugoœæ: ");
		dlugosc = odczyt.nextInt();
		odczyt.close();
		
		funkcja(dlugosc);
	}

}
