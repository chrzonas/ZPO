import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Lab3_2
{
	public static void main(String[] args)
	{
		ReadFile read = new ReadFile();
		String json = read.read();

		Gson gson = new Gson();

		Type hMapType = new TypeToken<HashMap<String, List<String>>>() {}.getType();

		Map<String, List<String>> hmapPolEng = new HashMap<String, List<String>>();

		hmapPolEng = gson.fromJson(json, hMapType);

		Set<String> key = hmapPolEng.keySet();
		String[] tabKey = new String[10];
		key.toArray(tabKey);
		List<String> listKey = new ArrayList<>();

		for (int i = 0; i < tabKey.length; i++)
		{
			listKey.add(tabKey[i]);
		}

		Random draw = new Random();
		Scanner in = new Scanner(System.in);

		Map<String, String> qa = new LinkedHashMap<>();

		int HowManyDraw = 10;
		int HowManyGoodAnswers = 0;

		System.out.print("Imie: ");
		String imie = in.nextLine();
		System.out.print("Nazwisko: ");
		String nazwisko = in.nextLine();

		System.out.println();
		System.out.println("--- Start Testu ---");
		System.out.println();
		long startTime = System.nanoTime();

		for (int i = 0; i < 5; i++)
		{
			int index = draw.nextInt(HowManyDraw);
			System.out.print("Podaj angielskie tlumaczenie " + listKey.get(index) + ": ");
			String answer = in.nextLine();

			qa.put(listKey.get(index), answer);
			answer = answer.toLowerCase();

			for (String translate : hmapPolEng.get(listKey.get(index)))
			{
				if (answer.equals(translate))
				{
					HowManyGoodAnswers += 1;
				}
			}

			listKey.remove(index);
			HowManyDraw -= 1;
		}
		
		long endTime = System.nanoTime() - startTime;

		double endTimeSec = (double) endTime / 1000000000;

		Type qaType = new TypeToken<HashMap<String, String>>() {}.getType();
		String qaJson = gson.toJson(qa, qaType);

		WriteFile write = new WriteFile();
		System.out.println();
		write.write(qaJson, imie, nazwisko);

		System.out.println("Liczba poprawnych odpowiedzi: " + HowManyGoodAnswers);
		System.out.println();
		System.out.println(String.format("Czas testu: %.2f", endTimeSec));

		in.close();
	}
}