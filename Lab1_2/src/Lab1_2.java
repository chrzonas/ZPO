import java.util.Scanner;
import java.math.BigInteger;

public class Lab1_2
{
	public static boolean funkcja(String numer)
	{
		boolean wynik;
		BigInteger mod = new BigInteger("97");
		BigInteger kontrolna = new BigInteger("0");
		int kontrolna2 = 0;
		
		numer = numer + "2521" + numer.charAt(0) + numer.charAt(1);
		numer = numer.substring(2);
		
		BigInteger konto = new BigInteger(numer);
		
		kontrolna = konto.mod(mod);
		kontrolna2 = kontrolna.intValue();
		
		if (kontrolna2 == 1)
		{
			wynik = true;
		}
		else
		{
			wynik = false;
		}

		return wynik;
	}

	public static void main(String[] args)
	{
		String numer;
		
		Scanner odczyt = new Scanner(System.in);
		System.out.print("Podaj numer konta: ");
		numer = odczyt.nextLine();
		odczyt.close();
		
		if (funkcja(numer) == true)
		{
			System.out.println("Numer konta jest poprawny.");
		}
		else
		{
			System.out.println("Numer konta jest niepoprawny.");
		}
	}

}
