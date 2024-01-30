package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student2 implements Comparable<Student2>{
	
	private int age;
	private String name;
	public Student2(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	
	
	}
	@Override
	public String toString() {
		return "Student2 [age=" + age + ", name=" + name + "]";
	}
	
	@Override
	public int compareTo(Student2 that) {
		if(this.age>that.age) {
			return 1;
		}else {
			return -1;
		}
	}
	
	
	
}

public class ComparableDemo {

	public static void main(String[] args) {
	
		List<Student2> myList = new ArrayList<>();
		myList.add(new Student2(27,"Dheeraj"));
		myList.add(new Student2(25,"Rahul"));
		myList.add(new Student2(26,"Samya"));
		System.out.println("Before sorting: "+myList);
		
		Collections.sort(myList);
		
		System.out.println("After sorting: "+myList);
	}
}
