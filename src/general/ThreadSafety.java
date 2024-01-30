package general;

class Counter{
	
	int c;
	
	public synchronized void increment() {
		c+=1;
	}
}

public class ThreadSafety {

	public static void main(String[] args) throws InterruptedException {
		
		Counter c = new Counter();
		
		Thread t1 = new Thread(()->{
			for(int i =0;i<1000;i++)
			c.increment();
		});
		
		Thread t2 = new Thread(()->{
			for(int j=0;j<1000;j++)
			c.increment();
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Counter value: "+c.c);
	}
}
