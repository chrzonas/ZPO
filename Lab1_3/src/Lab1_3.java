import java.util.Scanner;

public class Lab1_3
{
	public static void main(String[] args)
	{
		int liczba = 0;
		int s;
		int d;
		int j;
		
		String[] setki = new String[10];
		setki[0] = "";
		setki[1] = "sto";
		setki[2] = "dwie�cie";
		setki[3] = "trzysta";
		setki[4] = "czterysta";
		setki[5] = "pi��set";
		setki[6] = "sze��set";
		setki[7] = "siedemset";
		setki[8] = "osiemset";
		setki[9] = "dziewi��set";
		
		String[] dziesiatki = new String[10];
		dziesiatki[0] = "";
		dziesiatki[1] = "dziesi��";
		dziesiatki[2] = "dwadzie�cia";
		dziesiatki[3] = "trzydzie�ci";
		dziesiatki[4] = "czterydzie�ci";
		dziesiatki[5] = "pi��dziesi�t";
		dziesiatki[6] = "sze��dziesi�t";
		dziesiatki[7] = "siedemdziesi�t";
		dziesiatki[8] = "osiemdziesi�t";
		dziesiatki[9] = "dziewi��dziesi�t";
		
		String[] nastki = new String[10];
		nastki[0] = "";
		nastki[1] = "jedena�cie";
		nastki[2] = "dwana�cie";
		nastki[3] = "trzyna�cie";
		nastki[4] = "czterna�cie";
		nastki[5] = "pi�tna�cie";
		nastki[6] = "szesna�cie";
		nastki[7] = "siedemna�cie";
		nastki[8] = "osiemna�nie";
		nastki[9] = "dziewi�tna�cie";
		
		String[] jednosci = new String[10];
		jednosci[0] = "";
		jednosci[1] = "jeden";
		jednosci[2] = "dwa";
		jednosci[3] = "trzy";
		jednosci[4] = "cztery";
		jednosci[5] = "pi��";
		jednosci[6] = "sze��";
		jednosci[7] = "siedem";
		jednosci[8] = "osiem";
		jednosci[9] = "dziewi��";
		
		Scanner odczyt = new Scanner(System.in);
		System.out.print("Podaj liczb�: ");
		liczba = odczyt.nextInt();
		odczyt.close();
		
		if ((liczba <= 99)||(liczba >= 1000))
		{
			throw new NumberFormatException("Liczba musi by� w zakresie 100-999!");
		}
		
		s = liczba/100;
		d = (liczba-(s*100))/10;
		j = liczba-((s*100)+(d*10));
		
		if ((d == 1)&&(j != 0))
		{
			System.out.println("S�ownie: " + setki[s] + " " + nastki[j]);
		}
		else
		{
			System.out.println("S�ownie: " + setki[s] + " " + dziesiatki[d] + " " + jednosci[j]);
		}
	}

}
