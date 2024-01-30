package general;

public class MultiThreading {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable obj1 = () -> {
				for(int i=0;i<5;i++) {
					System.out.println("Hi");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
		
		Runnable obj2 = () -> {
			for(int i =0;i<5;i++) {
				System.out.println("Hello");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				
			};
		
		Thread t1 = new Thread(() -> {
			for(int i =0;i<5;i++) {
				System.out.println("Hi");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				
			});
		Thread t2 = new Thread(() ->{
			for(int i =0;i<5;i++) {
				System.out.println("Hello");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				
			});
		
		t1.start();
		
		Thread.sleep(10);
		
		t2.start();
		
		System.out.println(t1.isAlive()+":"+t2.isAlive());

		t1.join();
		t2.join();
		
		System.out.println(t1.isAlive()+":"+t2.isAlive());
		
		System.out.println("Bye");
	}
}
