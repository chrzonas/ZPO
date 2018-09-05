import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Lab3_3_Test
{
	String s1 = "Ala ma kota";
	String s2 = "mama";
	String s3 = null;
	int dl1 = 3;
	int dl2 = 2;
	int dl3 = 0;

	List<String> list1 = Arrays.asList("Ala", " ma", " ko", "ta");
	List<String> list2 = Arrays.asList("ma", "ma");

	@Test
	void test1()
	{
		List<String> result1 = Lab3_3.CutWithNonNull(s1, dl1);
		List<String> result2 = Lab3_3.CutWithNonNull(s2, dl2);

		assertLinesMatch(list1, result1);
		assertLinesMatch(list2, result2);
	}

	@Test
	void test2()
	{
		List<String> result1 = Lab3_3.CutSplitterGuava(s1, dl1);
		List<String> result2 = Lab3_3.CutSplitterGuava(s2, dl2);

		assertLinesMatch(list1, result1);
		assertLinesMatch(list2, result2);
	}

	@Test
	void test3()
	{
		assertThrows(NullPointerException.class, () -> {Lab3_3.CutWithNonNull(s3, dl2);});	
		assertThrows(NullPointerException.class, () -> {Lab3_3.CutSplitterGuava(s3, dl2);});
	}
	
	@Test
	void test4()
	{
		assertThrows(IllegalArgumentException.class, () -> {Lab3_3.CutWithNonNull(s1, dl3);});
		assertThrows(IllegalArgumentException.class, () -> {Lab3_3.CutSplitterGuava(s1, dl3);});
	}
}
