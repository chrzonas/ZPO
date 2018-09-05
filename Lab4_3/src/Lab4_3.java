import java.util.Map;

public class Lab4_3
{
	public static void merge1(String key, Integer var, Map<String, Integer> counts) throws NullPointerException
	{
        if (var == null)
        {
            counts.remove(key);
            throw new NullPointerException();
        }
        else if (counts.containsKey(key))
        {
            if (counts.get(key) == null)
            {
                counts.put(key, var);
            }
            else
            {
                counts.put(key, counts.get(key) + var);
            }
        }
        else
        {
            counts.put(key, var);
        }
    }

    public static void merge2(String key, Integer var, Map<String, Integer> counts) throws NullPointerException
    {
        if (var == null)
        {
            counts.remove(key);
            throw new NullPointerException();
        }
        else if (counts.get(key) == null)
        {
            counts.put(key, var);
        }
        else
        {
            counts.put(key, counts.get(key) + var);
        }
    }

    public static void merge3(String key, Integer var, Map<String, Integer> counts) throws NullPointerException
    {
        if (var == null)
        {
            counts.remove(key);
            throw new NullPointerException();
        }
        else if (counts.getOrDefault(key, var) == var)
        {
            counts.put(key, var);
        }
        else if (counts.getOrDefault(key, var) == null)
        {
            counts.put(key, var);
        }
        else
        {
            counts.put(key, counts.get(key) + var);
        }
    }

    public static void merge4(String key, Integer var, Map<String, Integer> counts) throws NullPointerException
    {
        if (var == null)
        {
            counts.remove(key);
            throw new NullPointerException();
        }
        else if (counts.putIfAbsent(key, var) == null);
        else
        {
            counts.put(key, counts.get(key) + var);
        }
    }
	
	public static void main(String[] args)
	{

	}
}