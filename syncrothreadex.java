package syncrothread;
class Counter
{
	int count;
	public synchronized void increment() {
		count++;
	}
}

public class syncrothreadex {
	
	public static void main(String[] args)
	{
		Counter c = new Counter();
		Thread t1 = new Thread(new Runnable()
		{
			public void run() 
			{
				for(int i=1;i<=100;i++) 
				{
					c.increment();	
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable()
		{
			public void run() 
			{
				for(int i=1;i<=100;i++) 
				{
					c.increment();	
				}
			}
		});
		
		t1.start();
		t2.start();
		try
		{
			 t1.join();
			//t2.join();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		//c.increment();
		System.out.println(c.count);
	}
}
