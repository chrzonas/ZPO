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
		setki[2] = "dwieœcie";
		setki[3] = "trzysta";
		setki[4] = "czterysta";
		setki[5] = "piêæset";
		setki[6] = "szeœæset";
		setki[7] = "siedemset";
		setki[8] = "osiemset";
		setki[9] = "dziewiêæset";
		
		String[] dziesiatki = new String[10];
		dziesiatki[0] = "";
		dziesiatki[1] = "dziesiêæ";
		dziesiatki[2] = "dwadzieœcia";
		dziesiatki[3] = "trzydzieœci";
		dziesiatki[4] = "czterydzieœci";
		dziesiatki[5] = "piêædziesi¹t";
		dziesiatki[6] = "szeœædziesi¹t";
		dziesiatki[7] = "siedemdziesi¹t";
		dziesiatki[8] = "osiemdziesi¹t";
		dziesiatki[9] = "dziewiêædziesi¹t";
		
		String[] nastki = new String[10];
		nastki[0] = "";
		nastki[1] = "jedenaœcie";
		nastki[2] = "dwanaœcie";
		nastki[3] = "trzynaœcie";
		nastki[4] = "czternaœcie";
		nastki[5] = "piêtnaœcie";
		nastki[6] = "szesnaœcie";
		nastki[7] = "siedemnaœcie";
		nastki[8] = "osiemnaœnie";
		nastki[9] = "dziewiêtnaœcie";
		
		String[] jednosci = new String[10];
		jednosci[0] = "";
		jednosci[1] = "jeden";
		jednosci[2] = "dwa";
		jednosci[3] = "trzy";
		jednosci[4] = "cztery";
		jednosci[5] = "piêæ";
		jednosci[6] = "szeœæ";
		jednosci[7] = "siedem";
		jednosci[8] = "osiem";
		jednosci[9] = "dziewiêæ";
		
		Scanner odczyt = new Scanner(System.in);
		System.out.print("Podaj liczbê: ");
		liczba = odczyt.nextInt();
		odczyt.close();
		
		if ((liczba <= 99)||(liczba >= 1000))
		{
			throw new NumberFormatException("Liczba musi byæ w zakresie 100-999!");
		}
		
		s = liczba/100;
		d = (liczba-(s*100))/10;
		j = liczba-((s*100)+(d*10));
		
		if ((d == 1)&&(j != 0))
		{
			System.out.println("S³ownie: " + setki[s] + " " + nastki[j]);
		}
		else
		{
			System.out.println("S³ownie: " + setki[s] + " " + dziesiatki[d] + " " + jednosci[j]);
		}
	}

}
