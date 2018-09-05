import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;

public class Race implements Runnable
{
	Log my_log = new Log("log.txt");
	CountDownLatch counter = null;

	public Race(CountDownLatch counter)
	{
		this.counter = counter;
	}

	ArrayList<String> listName = Get_URL.readNames();
	HashMap<Integer, String> timeName = new HashMap<Integer, String>();
	Queue<Integer> times = new PriorityQueue<>(15);

	int t1 = 380;
	int t2 = 390;
	int t3 = 400;
	
	String name1;
	String name2;
	String name3;

	int showCounter = 0;

	int losowanietimeu()
	{
		int time;
		Random r = new Random();
		time = (int) (r.nextGaussian() * 30 + 300);

		if (time < 250)
		{
			time = 250;
		}
		if (time > 370)
		{
			time = 370;
		}

		return time;
	}

	String drawName()
	{
		Random random = new Random();
		int size = listName.size();
		int index = random.nextInt(size);
		String name = listName.get(index);
		listName.remove(index);
		return name;
	}

	@Override
	public void run()
	{

		String name = drawName();
		int time = losowanietimeu();

		times.add(time);
		int bestTime = times.poll();

		if (timeName.isEmpty())
			timeName.put(time, name);
		else
		{
			if (timeName.containsKey(time))
			{
				String oldTime = timeName.get(time);
				timeName.replace(time, oldTime + ", " + name);
			}
			else
			{
				timeName.put(time, name);
			}
		}

		if (bestTime < t1)
		{
			t3 = t2;
			t2 = t1;
			t1 = bestTime;
		} 
		else if (bestTime < t2 && bestTime > t1)
		{
			t3 = t2;
			t2 = bestTime;
		} 
		else if (bestTime < t3 && bestTime > t2)
		{
			t3 = bestTime;
		}

		my_log.logger.setLevel(Level.FINE);
		my_log.logger.fine("--- Zawodnik nr " + (showCounter + 1) + " " + name + ": " + time + "s. ---");

		System.out.println("--- Zawodnik nr " + (showCounter + 1) + " " + name + ": " + time + "s. ---");
		System.out.println();

		switch (showCounter)
		{
			case (0):
			{
				System.out.println("--- Klasyfikacja ---");
				System.out.println("1. " + t1 + "s. " + timeName.get(t1));
				System.out.println();
				break;
			}
			case (1):
			{
				System.out.println("--- Klasyfikacja ---");
				System.out.println("1. " + t1 + "s. " + timeName.get(t1));
				System.out.println("2. " + t2 + "s. " + timeName.get(t2));
				System.out.println();
				break;
			}
			default:
				System.out.println("--- Klasyfikacja ---");
				System.out.println("1. " + t1 + "s. " + timeName.get(t1));
				System.out.println("2. " + t2 + "s. " + timeName.get(t2));
				System.out.println("3. " + t3 + "s. " + timeName.get(t3));
				System.out.println();
		}
		
		showCounter += 1;

		this.counter.countDown();
	}
}