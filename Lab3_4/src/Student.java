import java.util.List;

import com.google.common.base.Splitter;

public class Student
{
	private String imie;
	private String nazwisko;
	private String dataUrodzenia;
	private int wzrost;

	public Student(String imie, String nazwisko, String dataUrodzenia, int wzrost)
	{
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.dataUrodzenia = dataUrodzenia;
		this.wzrost = wzrost;
	}

	public String getName()
	{
		return this.imie;
	}

	public String getSurname()
	{
		return this.nazwisko;
	}

	public String getDateOfBirth()
	{
		return this.dataUrodzenia;
	}

	public int getGrowth()
	{
		return this.wzrost;
	}

	public int getYear()
	{
		int rok = 0;

		List<String> dzienMiesiacRok = (List<String>) Splitter.on('.').splitToList(this.dataUrodzenia);
		rok = Integer.parseInt(dzienMiesiacRok.get(2));

		return rok;
	}

	public String getFirstLetterSurname()
	{
		String litera = this.nazwisko.substring(0, 1);

		return litera;
	}
	
	@Override
	public String toString()
	{
		return String.format("%3s  %-10s  %10s  %3s cm", imie, nazwisko, dataUrodzenia, wzrost);
	}
}