import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;

public class Killer implements Runnable
{
	CountDownLatch counter = null;
	ScheduledExecutorService watek;

	public Killer(CountDownLatch licznik, ScheduledExecutorService watek)
	{
		this.counter = licznik;
		this.watek = watek;
	}

	public void run()
	{
		try
		{
			counter.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		this.watek.shutdownNow();
		System.out.println("--- Koniec ---");

	}
}
