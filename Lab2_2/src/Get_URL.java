import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.net.URL;

public class Get_URL
{
	public static ArrayList<String> readNames()
	{
		URL names = null;
		
		try
		{
			names = new URL("https://raw.githubusercontent.com/chrzonas/ZPO/master/Lab2_2/nazwiska.txt");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		BufferedReader in = null;
		
		try
		{
			in = new BufferedReader(new InputStreamReader(names.openStream(), "UTF-8"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		String name;
		ArrayList<String> listNames = new ArrayList<String>();

		try
		{
			while ((name = in.readLine()) != null)
			{
				listNames.add(name);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			in.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return listNames;
	}
}
