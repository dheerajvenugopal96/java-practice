package general;


interface Marker{
	
}

class Demo implements Marker{
	
	void show() {
		System.out.println("Hello");
	}
}

public class MakerInterface {

	public static void main(String[] args) {
		
		Demo demo = new Demo();
		if (demo instanceof Marker) {
			demo.show();
			
		}else {
			System.out.println("No");
		}
	}
}
