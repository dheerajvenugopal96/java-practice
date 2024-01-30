package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Container<T>{
	
	T value;
	
	public void show() {
		System.out.println("value  "+value+" is of type "+value.getClass().getSimpleName());
	}
}

class Container2<T extends Number>{
	T value;
	public void show2() {
		System.out.println("value  "+value+" is of type "+value.getClass().getSimpleName());
	}
}

class Container3<T>{
	
	public void printList(List<? extends T> myList) {
		System.out.println(myList);
	}
}

class School{
	
	public void schoolName() {
		System.out.println("My school is Devamatha CMI Public School");
	}
}

class Student extends School{
	
	
}

class Container6<T>{
	
	public void printList(List<? super Student> myList) {
		System.out.println(myList);
	}
}

public class GenericsExample {
	
	public static void main(String[] args) {
		
		Container<Integer> container1 = new Container<>();
		container1.value = 10;
		container1.show();
		
		Container<String> container2 = new Container<>();
		container2.value = "Dheeru";
		container2.show();
		
		Container<Boolean> container3 = new Container<>();
		container3.value = true;
		container3.show();
		
		Container2<Double> container4 = new Container2<>();
		container4.value = 10.0;
		container4.show2();
		
		Container3<Number> container5 = new Container3<>();
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		container5.printList(numbers);
		
		Container6<Student> container6 = new Container6<>();
		School sch1 = new School();
		School sch2 = new School();
		List<School> schoolList = new ArrayList<>();
		schoolList.add(sch1);
		schoolList.add(sch2);
		container6.printList(schoolList);
		
	}

}
