import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Lab4_2_Test
{
	List<String> list1 = Arrays.asList("AAA", "BBB", "CCC");
	
	List<String> list2 = Arrays.asList("aaa", "bbb", "ccc");
	List<String> list3 = Arrays.asList("aaa", "bbb", "ccc");
	List<String> list4 = Arrays.asList("aaa", "bbb", "ccc");

	@Test
	void test1()
	{
		Lab4_2.replace(list2);
		assertLinesMatch(list2, list1);
	}

	@Test
	void test2()
	{
		Lab4_2.replace2(list3);
		assertLinesMatch(list3, list1);
	}

	@Test
	void test3()
	{
		Lab4_2.replace3(list4);
		assertLinesMatch(list4, list1);
	}
}
