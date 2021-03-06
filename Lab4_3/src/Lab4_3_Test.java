import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Lab4_3_Test
{
	Map<String, Integer> counts;
	Map<String, Integer> counts1;
	Map<String, Integer> counts2;
	Map<String, Integer> counts3;
	Map<String, Integer> counts4;
	
	@BeforeEach
	void createMap()
	{
		counts = new HashMap<>();
		counts1 = new HashMap<>();
		counts2 = new HashMap<>();
		counts3 = new HashMap<>();
		counts4 = new HashMap<>();
	}
	

	@Test
	void test1()
	{
        counts.put("word", 2);
        
        assertThrows(NullPointerException.class,() -> Lab4_3.merge1("word", null, counts));
        assertThrows(NullPointerException.class,() -> Lab4_3.merge2("word", null, counts));
        assertThrows(NullPointerException.class,() -> Lab4_3.merge3("word", null, counts));
        assertThrows(NullPointerException.class,() -> Lab4_3.merge4("word", null, counts));
        assertThrows(NullPointerException.class,() -> counts.merge("word", null, Integer::sum));
	}
	
	@Test
	void test2()
	{
		
        counts.put("word", 2);
        counts1.put("word", 2);
        counts2.put("word", 2);
        counts3.put("word", 2);
        counts4.put("word", 2);
        
        counts.merge("word", 1, Integer::sum);
        Lab4_3.merge1("word", 1, counts1);
        Lab4_3.merge2("word", 1, counts2);
        Lab4_3.merge3("word", 1, counts3);
        Lab4_3.merge4("word", 1, counts4);
        
        assertEquals((Integer) 3, counts.get("word"));
        assertEquals((Integer) 3, counts1.get("word"));
        assertEquals((Integer) 3, counts2.get("word"));
        assertEquals((Integer) 3, counts3.get("word"));
        assertEquals((Integer) 3, counts4.get("word"));
	}
	
	@Test
	void test3()
	{
        counts.put("word", null);
        counts1.put("word", null);
        counts2.put("word", null);
        counts3.put("word", null);
        counts4.put("word", null);
        
        counts.merge("word", 1, Integer::sum);
        Lab4_3.merge1("word", 1, counts1);
        Lab4_3.merge2("word", 1, counts2);
        Lab4_3.merge3("word", 1, counts3);
        Lab4_3.merge4("word", 1, counts4);
        
        assertEquals((Integer) 1, counts.get("word"));
        assertEquals((Integer) 1, counts1.get("word"));
        assertEquals((Integer) 1, counts2.get("word"));
        assertEquals((Integer) 1, counts3.get("word"));
        assertEquals((Integer) 1, counts4.get("word"));
	}
	
	@Test
	void test4()
	{
        counts.put("word", 2);
        counts1.put("word", 2);
        counts2.put("word", 2);
        counts3.put("word", 2);
        counts4.put("word", 2);
        
        counts.merge(null, 1, Integer::sum);
        Lab4_3.merge1(null, 1, counts1);
        Lab4_3.merge2(null, 1, counts2);
        Lab4_3.merge3(null, 1, counts3);
        Lab4_3.merge4(null, 1, counts4);
        
        assertEquals((Integer) 2, counts.get("word"));
        assertEquals((Integer) 2, counts1.get("word"));
        assertEquals((Integer) 2, counts2.get("word"));
        assertEquals((Integer) 2, counts3.get("word"));
        assertEquals((Integer) 2, counts4.get("word"));
	}
	
	@Test
	void test5()
	{
        counts.put(null, 2);
        counts1.put(null, 2);
        counts2.put(null, 2);
        counts3.put(null, 2);
        counts4.put(null, 2);
        
        counts.merge("word", 1, Integer::sum);
        Lab4_3.merge1("word", 1, counts1);
        Lab4_3.merge2("word", 1, counts2);
        Lab4_3.merge3("word", 1, counts3);
        Lab4_3.merge4("word", 1, counts4);
        
        assertEquals((Integer) 1, counts.get("word"));
        assertEquals((Integer) 1, counts1.get("word"));
        assertEquals((Integer) 1, counts2.get("word"));
        assertEquals((Integer) 1, counts3.get("word"));
        assertEquals((Integer) 1, counts4.get("word"));
	}
}
