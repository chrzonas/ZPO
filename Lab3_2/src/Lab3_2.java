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

		Set<String> klucze = hmapPolEng.keySet();
		String[] tabKlucze = new String[10];
		klucze.toArray(tabKlucze);
		List<String> listaKlucze = new ArrayList<>();

		for (int i = 0; i < tabKlucze.length; i++)
		{
			listaKlucze.add(tabKlucze[i]);
		}

		Random losowanie = new Random();
		Scanner in = new Scanner(System.in);

		Map<String, String> pytanieOdpowiedz = new LinkedHashMap<>();

		int liczbaLosowan = 10;
		int liczbaPoprawnychOdpowiedzi = 0;

		System.out.print("Imie: ");
		String imie = in.nextLine();
		System.out.print("Nazwisko: ");
		String nazwisko = in.nextLine();

		System.out.println("******* Test START *******");
		System.out.println();
		long startTime = System.nanoTime();

		for (int i = 0; i < 5; i++)
		{
			int index = losowanie.nextInt(liczbaLosowan);
			System.out.println("Angielskie tlumaczenie: " + listaKlucze.get(index));
			String odpowiedz = in.nextLine();

			pytanieOdpowiedz.put(listaKlucze.get(index), odpowiedz);
			odpowiedz = odpowiedz.toLowerCase();

			for (String tlumaczenie : hmapPolEng.get(listaKlucze.get(index)))
			{
				if (odpowiedz.equals(tlumaczenie))
				{
					liczbaPoprawnychOdpowiedzi += 1;
				}
			}

			listaKlucze.remove(index);
			liczbaLosowan -= 1;
		}
		
		long endTime = System.nanoTime() - startTime;

		double endTimeSekundy = (double) endTime / 1000000000;

		Type pytanieOdpowiedzType = new TypeToken<HashMap<String, String>>() {}.getType();
		String pytanieOdpowiedzJson = gson.toJson(pytanieOdpowiedz, pytanieOdpowiedzType);

		WriteFile write = new WriteFile();
		System.out.println();
		System.out.println("Trwa zapisywanie do pliku....");
		write.write(pytanieOdpowiedzJson, imie, nazwisko);

		System.out.println();
		System.out.println("Liczba poprawnych odpowiedzi: " + liczbaPoprawnychOdpowiedzi);
		System.out.println();
		System.out.println(String.format("Czas testu: %.2f", endTimeSekundy));

		in.close();
	}
}