package general;

public interface MyInterface {

	private static void hello() {
		System.out.println("Say Hello"); //cannot be overriden
	}
	
	private static void bro() {
		System.out.println("Hello bro"); //cannot be overriden
	}
	
	void doSomething() ;
	
	default void method() {
		System.out.println("Default method"); //can be overriden and implemented
	}
	
	default void anotherMethod() {
		System.out.println("Yellow"); //can be overriden and implemented
	}
}
