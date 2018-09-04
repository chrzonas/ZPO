import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Lab2_2
{
	public static void main(String[] args)
	{
		CountDownLatch iloscZawodnikow = new CountDownLatch(15);

		Race wyscig = new Race(iloscZawodnikow);
		Runnable wyscigRunnable = wyscig;

		ScheduledExecutorService watek = Executors.newSingleThreadScheduledExecutor();

		Killer killer = new Killer(iloscZawodnikow, watek);
		Runnable kil = killer;

		ExecutorService watek2 = Executors.newSingleThreadExecutor();

		watek.scheduleAtFixedRate(wyscigRunnable, 0, 2400, TimeUnit.MILLISECONDS);

		watek2.submit(kil);
	}
}
