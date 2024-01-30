package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class FibonacciUsingForkJoin extends RecursiveTask<Integer> {

	final int n;
	
	public FibonacciUsingForkJoin(int n) {
		this.n = n;
	}
	
	@Override
	protected Integer compute() {
		if(n<=1) {
			return n;
		}

		FibonacciUsingForkJoin f1 = new FibonacciUsingForkJoin(n-1);
		f1.fork();
		FibonacciUsingForkJoin f2 = new FibonacciUsingForkJoin(n-2);
		f2.fork();
		return f1.join()+f2.join();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FibonacciUsingForkJoin result = new FibonacciUsingForkJoin(11);
		Integer result2 = result.compute();
		System.out.println(result2);
	}

}
