import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Lab2_1_Test
{
	@Test
	public void test1()
	{
		assertEquals(1.5, Lab2_1.LevQWERTY("kot", "kita"), 0);
	}

	@Test
	public void test2()
	{
		assertEquals(2, Lab2_1.LevQWERTY("drab", "dal"), 0);
	}
}