import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Lab3_1
{
	
	public static void sortStrings(Collator collator, String[] words)
	{
		int i = 0;
		int j = 0;
		String tmp;
		
		for (i = 0; i < words.length; i++)
		{
			for (j = 0; j < words.length - 1; j++)
			{
				if (collator.compare(words[j], words[j + 1]) > 0)
				{
					tmp = words[j + 1];
					words[j + 1] = words[j];
					words[j] = tmp;
				}
			}
		}
		
		for (i = 0 ; i < 3 ; i++)
		{
			System.out.println(words[i]);
		}
	}
	
	public static void fastSortStrings(Collator collator, String[] words)
	{
		int i = 0;
		
		Arrays.sort(words, new Comparator<String>()
		{
			@Override
			public int compare(String s1, String s2)
			{
				return collator.compare(s1, s2);
			}
		});
		
		for (i = 0 ; i < 3 ; i++)
		{
			System.out.println(words[i]);
		}
	}
	
	public static void fastSortStrings2(Collator collator, String[] words)
	{
		int i = 0;
		
		Arrays.sort(words, (String s1, String s2) -> {
			return collator.compare(s1, s2);
		});
		
		for (i = 0 ; i < 3 ; i++)
		{
			System.out.println(words[i]);
		}
	}

	public static void main(String[] args)
	{
		Collator collator = Collator.getInstance(new Locale("pl", "PL"));
		String words[] = new String[3];
		
		words[0] = "£ukasz";
		words[1] = "Marek";
		words[2] = "Lucyna";
		
		System.out.println("---Funkcja sortStrings---");
		sortStrings(collator, words);
		System.out.println("---Funkcja fastSortStrings---");
		fastSortStrings(collator, words);
		System.out.println("---Funkcja fastSortStrings2---");
		fastSortStrings2(collator, words);
	}

}
