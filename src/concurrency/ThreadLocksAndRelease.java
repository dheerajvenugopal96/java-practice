package concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocksAndRelease {
	
	private static ReentrantLock lock = new ReentrantLock();
	
	private static int ticketCount = 10;
	
	private static void bookTicket() {
		
		lock.lock();
		try {
		ticketCount--;
		}finally {
			lock.unlock();	
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(()->bookTicket());
		Thread t2 = new Thread(()->bookTicket());
		Thread t3 = new Thread(()->bookTicket());
		Thread t4 = new Thread(()->bookTicket());
	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("Remaining tickets: "+ticketCount);
	}

}
