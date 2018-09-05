import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Lab4_1
{
	public static void main(String[] args)
	{
	        List<String> list = new ArrayList<>();
	        
	        try (Stream<String> stream = new BufferedReader(new FileReader("dane.txt")).lines())
	        {
	            stream.filter(s -> s.contains("PL")).forEach(list::add);
	        } catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        }

	        Pattern p = Pattern.compile("\\d+");

	        List<Integer> listSalary = new ArrayList<>();

	        for (int i = 0; i < list.size(); i++)
	        {
	            String element = list.get(i);
	            Matcher m = p.matcher(element);
	            m.find();
	            int Salary = Integer.parseInt(m.group());
	            listSalary.add(Salary);
	        }

	        System.out.println("Suma: " + listSalary.stream().sorted().peek(s -> System.out.println("Najmniejsze pensje: " + s)).limit(2).mapToInt(Integer::intValue).sum());
	        System.out.println();
	        System.out.println("Suma: " + listSalary.stream().sorted(Comparator.reverseOrder()).peek(s -> System.out.println("Najwieksze pensje: " + s)).limit(2).mapToInt(Integer::intValue).sum());
	}
}
