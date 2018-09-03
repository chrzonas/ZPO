import java.util.Scanner;

public class Lab1_1
{
	public static void main(String[] args)
	{
		int liczba = 11011011;
		String binarna;
		int i = 0;
		int j = 0;
		int dziesietna = 0;
		int cyfra[] = new int[10];
		int wynik = 0;
		int potega = 0;
		String wybor;
		
		Scanner odczyt = new Scanner(System.in);
		System.out.print("Podaj system: ");
		wybor = odczyt.nextLine();
		odczyt.close();
		
		binarna = Integer.toString(liczba);
		
		switch(wybor)
		{
			case "trzy":
			{
				for (i = binarna.length()-1 ; i >= 0 ; i--)
				{
					
					if (binarna.charAt(i) == '1')
					{
						dziesietna = dziesietna + (int)Math.pow(2, potega);
					}
					
					potega++;
				}
				
				i = 0;
				
				while (dziesietna != 0)
				{
					cyfra[i] = dziesietna%3;
					dziesietna = dziesietna/3;
					i++;
				}
		
				System.out.print("Liczba w systemie trójkowym: ");
				
				for (j = i-1 ; j >= 0 ; j--)
				{
					System.out.print(cyfra[j]);
				}
				
				break;
			}
			case "dziesiêæ":
			{
				for (i = binarna.length()-1 ; i >= 0 ; i--)
				{
					
					if (binarna.charAt(i) == '1')
					{
						wynik = wynik + (int)Math.pow(2, potega);
					}
					
					potega++;
				}
				
				System.out.println("Liczba w systemie dziesiêtnym: " + wynik);
				break;
			}
			case "szesnaœcie":
			{
				for (i = binarna.length()-1 ; i >= 0 ; i--)
				{
					
					if (binarna.charAt(i) == '1')
					{
						dziesietna = dziesietna + (int)Math.pow(2, potega);
					}
					
					potega++;
				}
				
				i = 0;
				
				while (dziesietna != 0)
				{
					cyfra[i] = dziesietna%16;
					dziesietna = dziesietna/16;
					i++;
				}
		
				System.out.print("Liczba w systemie szesnastkowym: ");
				
				for (j = i-1 ; j >= 0 ; j--)
				{
					if (cyfra[j] == 10)
					{
						System.out.print("A");
					}
					else if (cyfra[j] == 11)
					{
						System.out.print("B");
					}
					else if (cyfra[j] == 12)
					{
						System.out.print("C");
					}
					else if (cyfra[j] == 13)
					{
						System.out.print("D");
					}
					else if (cyfra[j] == 14)
					{
						System.out.print("E");
					}
					else if (cyfra[j] == 15)
					{
						System.out.print("F");
					}
					else
					{
						System.out.print(cyfra[j]);
					}
					
				}
				
				break;
			}
			default:
			{
				System.out.println("Z³y wybór!");
				break;
			}
		}
	}
}
