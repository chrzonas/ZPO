import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.net.URL;

public class Get_URL
{
	public static ArrayList<String> odczytNazwisk()
	{
		URL nazwiska = null;
		try
		{
			nazwiska = new URL("https://raw.githubusercontent.com/chrzonas/ZPO/master/Lab2_2/nazwiska_lab2_2.txt");
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		BufferedReader in = null;
		
		try
		{
			in = new BufferedReader(new InputStreamReader(nazwiska.openStream(), "UTF-8"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		String nazwisko;
		ArrayList<String> listNazwiska = new ArrayList<String>();

		try
		{
			while ((nazwisko = in.readLine()) != null)
			{
				listNazwiska.add(nazwisko);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			in.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return listNazwiska;
	}
}
