package concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolFuturesAndCallbacks {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
//		service.execute(new Task()); //.execute works only with Runnable 
		
		//for callable use .submit()
		Future<Integer> result = service.submit(new Task());
		service.execute(new Task2());
	
		
		System.out.println("Thread name: "+Thread.currentThread().getName());
		System.out.println("Exectuing line 1 while future is getting calculated");
		System.out.println("Executing line 2 while future is getting calculated");
		
		System.out.println(result.get());
		
		System.out.println("Line would be executed only after 3 seconds as get is blocking flow");
		
		service.shutdown(); //call shutdown or else thread will keep running waiting for task
		
	}
	
	
	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			
			System.out.println("Thread pool name: "+Thread.currentThread().getName());
			Thread.sleep(3000);
			return new Random().nextInt(1000);
		}
		
	}
	
	static class Task2 implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread pool name: "+Thread.currentThread().getName());

			
		}
		
	}
}
