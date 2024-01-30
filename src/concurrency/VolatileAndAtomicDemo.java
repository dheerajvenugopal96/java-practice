package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

class Demo{
	volatile boolean flag = true;
}

class AtomicDemo{
	int counter = 0;
	
	AtomicInteger counterEnhanced = new AtomicInteger(0);
}

@SuppressWarnings("unused")
public class VolatileAndAtomicDemo {
	

	public static void main(String[] args) throws InterruptedException {
		
//		demoVolatile();
//		demoAtomic();
		
		
		
	}

	private static void demoAtomic() throws InterruptedException {

		AtomicDemo d = new AtomicDemo();
		
		Thread t1 = new Thread(()->{
			for(int i =0;i<1000;i++) {
				d.counter++;
				d.counterEnhanced.getAndIncrement();
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i =0;i<1000;i++) {
				d.counter++;
				d.counterEnhanced.getAndIncrement();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Counter is: "+d.counter);
		System.out.println("Enhanced Counter is: "+d.counterEnhanced.get());
		
	}

	private static void demoVolatile() {
		Demo d = new Demo();
		Thread t1 = new Thread(()->{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			d.flag=false;
		});
		
		Thread t2 = new Thread(()->{
			
			while(d.flag) {
				System.out.println("Flag is false");
				try{Thread.sleep(1000);}catch(Exception e) {}

			}
		});
		
		t1.start();
		t2.start();
		
	}

}
