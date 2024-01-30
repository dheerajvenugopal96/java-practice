package concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
	
	private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
	private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
	
	private static int ticketcount = 10;
	
	
	public static void readResource() {
		readLock.lock();
		System.out.println("Thread "+Thread.currentThread().getName()+" read ticket with value: "+ticketcount);
		readLock.unlock();
	}
	
	public static void writeResource() {
		writeLock.lock();
		try {
			ticketcount--;
		}finally {
			writeLock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(()->readResource());
		Thread t2 = new Thread(()->readResource());
		Thread t3 = new Thread(()->writeResource());
		Thread t4 = new Thread(()->writeResource());
	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("Remaining tickets: "+ticketcount);
	}

}
