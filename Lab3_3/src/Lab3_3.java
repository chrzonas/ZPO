import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import com.google.common.base.Splitter;

public class Lab3_3
{
	public static List<String> CutWithOutNonNull(String s, int length)
	{

		if (s == null || length <= 0)
		{
			throw new IllegalArgumentException();
		}

		List<String> cut = new ArrayList<>();
		int dlS = s.length();
		int var = dlS % length;

		int jump = 0;

		if (var == 0)
		{
			for (int i = 0; i < dlS; i += length)
			{
				jump = i + length;
				cut.add(s.substring(i, jump));
			}
		}
		else
		{
			int i;
			
			for (i = 0; i < dlS - var; i += length)
			{
				jump = i + length;
				cut.add(s.substring(i, jump));
			}

			cut.add(s.substring(i, jump + var));
		}

		return cut;
	}
	
	public static List<String> CutWithNonNull(@NonNull String s, int length) {

		if (length <= 0)
		{
			throw new IllegalArgumentException();
		}

		List<String> cut = new ArrayList<>();
		int dlS = s.length();
		int var = dlS % length;

		int jump = 0;

		if (var == 0)
		{
			for (int i = 0; i < dlS; i += length)
			{
				jump = i + length;
				cut.add(s.substring(i, jump));
			}
		}
		else
		{
			int i;
			
			for (i = 0; i < dlS - var; i += length)
			{
				jump = i + length;
				cut.add(s.substring(i, jump));
			}

			cut.add(s.substring(i, jump + var));
		}

		return cut;
	}
	
	public static List<String> CutSplitterGuava(String s, int length) {

		List<String> cut = (List<String>) Splitter.fixedLength(length).splitToList(s);

		return cut;
	}

	
	public static void main(String[] args) {

		String s = "Ala ma kota";
		int dl = 3;

		List<String> cut = CutWithOutNonNull(s, dl);
		List<String> cut2 = CutWithNonNull(s, dl);
		List<String> cut3 = CutSplitterGuava(s, dl);
		
		System.out.print("Funkcja CutWithOutNonNull: ");

		for (String show : cut)
		{
			System.out.print("\"" + show + "\" ");
		}

		System.out.println();
		
		System.out.print("Funkcja CutWithNonNull: ");

		for (String show : cut2)
		{
			System.out.print("\"" + show + "\" ");
		}

		System.out.println();
		
		System.out.print("Funkcja CutSplitterGuava: ");

		for (String show : cut3)
		{
			System.out.print("\"" + show + "\" ");
		}

	}
}
