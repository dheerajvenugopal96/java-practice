package general;

class Q{
	
	int num;
	
	boolean setValue = false;

	public synchronized void  getNum() {
		while(!setValue) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Get: "+num);
		setValue = false;
		notify();
	}

	public synchronized void setNum(int num) {
		
		while(setValue) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Put: "+num);
		this.num = num;
		setValue = true;
		notify();
	}
	
	
}

class Producer implements Runnable{
	
	Q q;

	public Producer(Q q) {
		this.q = q;
		Thread t1 = new Thread(this,"Producer");
		t1.start();
	}
	
	public void run() {
		int i=0;
		while(true) {
			q.setNum(i++);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

class Consumer implements Runnable{
	
	Q q;

	public Consumer(Q q) {
		this.q = q;
		Thread t2 = new Thread(this,"Consumer");
		t2.start();
	}
	
	public void run() {
		while(true) {
			q.getNum();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

public class InterthreadCommunication {
	
	public static void main(String[] args) {
		
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}

}
