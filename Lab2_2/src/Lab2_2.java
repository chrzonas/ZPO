import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Lab2_2
{
	public static void main(String[] args)
	{
		CountDownLatch howManyCyclists = new CountDownLatch(15);

		Race race = new Race(howManyCyclists);
		Runnable raceRunnable = race;
		
		System.out.println("--- Start ---");
		System.out.println();

		ScheduledExecutorService watek = Executors.newSingleThreadScheduledExecutor();

		Killer killer = new Killer(howManyCyclists, watek);
		Runnable killRunnable = killer;

		ExecutorService watek2 = Executors.newSingleThreadExecutor();

		watek.scheduleAtFixedRate(raceRunnable, 0, 2400, TimeUnit.MILLISECONDS);

		watek2.submit(killRunnable);
	}
}
