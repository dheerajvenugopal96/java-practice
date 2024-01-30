package concurrency;

public class JavaInterruptsDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Task());
		t1.start();
		System.out.println("waiting for 2 secs before interrupting");
		Thread.sleep(2000);
		t1.interrupt();
	}
	
	static class Task implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("i will wait for 20 secs..Hope no one interrupts me!!");
				Thread.sleep(20000);
			}catch(InterruptedException e) {
				System.out.println("Interrurpted while waiting...DAMN IT!!!!");
				return;
			}
			
		}
		
	}

}
