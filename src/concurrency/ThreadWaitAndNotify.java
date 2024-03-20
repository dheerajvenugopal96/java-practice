package concurrency;

public class ThreadWaitAndNotify {
	public static Integer limit =10;
	public static Object lock = new Object();
	public static Integer number = 1;
	public static Boolean isOdd = true;
	
	public static void main(String[] args) {
	
		Thread oddThread = new Thread(()->{
			
			while(number<=limit && isOdd) {
				System.out.println("Odd: "+number);
				isOdd=!isOdd;
				number++;
				synchronized (lock) {
					try {
						lock.wait();
					}catch(InterruptedException e) {
						
					}
				}
			}
		}); 
		
		
		Thread evenThread = new Thread(()->{
			while(number<=limit) {
				synchronized (lock) {
					if(!isOdd) {
						System.out.println("Even: "+number);
						number++;
						isOdd=!isOdd;
					}
					lock.notify();

				}
				
			}
		});
		
		oddThread.start();
		evenThread.start();
	}
}
