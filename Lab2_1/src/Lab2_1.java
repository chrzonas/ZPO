import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Lab2_1
{
	
	public static double LevQWERTY(String s1, String s2)
	{
		double result[][];
		double t = 0.0;
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int p = 0;
		boolean r = false;
		String character;
		
		Map<Character, String> tmap = new HashMap<Character, String>();

		tmap.put('q', "w");
		tmap.put('w', "qe");
		tmap.put('e', "wr");
		tmap.put('r', "et");
		tmap.put('t', "ry");
		tmap.put('y', "tu");
		tmap.put('u', "yi");
		tmap.put('i', "uo");
		tmap.put('o', "ip");
		tmap.put('p', "o");
		tmap.put('a', "s");
		tmap.put('s', "ad");
		tmap.put('d', "sf");
		tmap.put('f', "dg");
		tmap.put('g', "fh");
		tmap.put('h', "gj");
		tmap.put('j', "hk");
		tmap.put('k', "jl");
		tmap.put('l', "k");
		tmap.put('z', "x");
		tmap.put('x', "zc");
		tmap.put('c', "xv");
		tmap.put('v', "cb");
		tmap.put('b', "vn");
		tmap.put('n', "bm");
		tmap.put('m', "n");
		
		k = s1.length();
		l = s2.length();
		
		result = new double[k+1][l+1];
		
		for (i = 0 ; i <= k ; i++)
		{
			result[i][0] = i;
		}
		
		for (j = 1 ; j <= l ; j++)
		{
			result[0][j] = j;
		}
		
		for (i = 1 ; i <= k ; i++)
		{
			for (j = 1 ; j <= l ; j++)
			{
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
				{
					t = 0;
				}
				else
				{
					character = tmap.get(s2.charAt(j - 1));
					
					for (p = 0 ; p < character.length() ; p++)
					{
						if (character.charAt(p) == s1.charAt(i - 1))
						{
							r = true;
						}
					}
					
					if (r == true)
					{
						t = 0.5;
					}
					else
					{
						t = 1;
					}
				}
				
				result[i][j] = Math.min(result[i - 1][j] + 1, Math.min(result[i][j - 1] + 1, result[i - 1][j - 1] + t));
			}
		}
		
		return result[k][l];
	}

	public static void main(String[] args)
	{
		String s1;
		String s2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Pierwsze slowo: ");
		s1 = scan.nextLine();

		System.out.println("Drugie slowo: ");
		s2 = scan.nextLine();
		
		System.out.println("Odleglosc Levenshteina wynosi: " + LevQWERTY(s1, s2));
		
		scan.close();
	}
}
