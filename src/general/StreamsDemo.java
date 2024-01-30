package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
	int id;
	String name;
	double price;

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

public class StreamsDemo {

	public static void main(String[] args) {

		// testFilter();
		// testFilter2();
		// testFilter3();
//		testFilter4();
//		mapTest1();
//		flatMapTest();
//		flatMapTest2();
//		otherStreamFunctions();
//		otherStreamFunctions2();
//		otherStreamFunctions3();
		
	}

	private static void otherStreamFunctions3() {
		
		Product p1 = new Product(1, "abc", 10.0);
		Product p2 = new Product(2, "def", 15.0);
		Product p3 = new Product(3, "ghi", 12.0);
		Product p4 = new Product(4, "jkl", 13.0);

		List<Product> prodList = new ArrayList<>();
		prodList.add(p1);
		prodList.add(p2);
		prodList.add(p3);
		prodList.add(p4);
		
		Double sum = prodList.stream().mapToDouble(x -> x.price).sum();
		System.out.println(sum);
		
//		prodList.stream().filter(x -> x.price<20).peek(System.out::println).forEach(System.out::println);
		
		prodList.stream().skip(2).filter(x -> x.price%2==0).forEach(System.out::println);
	}

	private static void otherStreamFunctions2() {
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(1);
		list2.add(4);
		list2.add(6);
		list2.add(5);
		
		List<Integer> sortedList = list2.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		
		List<Integer> sortedReverse = list2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortedReverse);
		
		List<String> names = Arrays.asList("Dheeraj", "Rahul", "Gautam", "Rani", "Mohan");
		List<String> namesSorted = names.stream().sorted().collect(Collectors.toList());
		System.out.println(namesSorted);
		
		boolean result = names.stream().anyMatch(x -> {return x.startsWith("Dh");});
		System.out.println(result);
		
		result = names.stream().allMatch(x -> x.length()>4);
		System.out.println(result);
		
		result = names.stream().noneMatch(x->x.length()>8);
		System.out.println(result);
		
		
		String res = names.stream().findAny().orElse(null);
		System.out.println(res);
		
		
		res = names.stream().findFirst().orElse(null);
		System.out.println(res);
		
		List<String> teamA = Arrays.asList("Dheeraj", "Rahul");
		List<String> teamB = Arrays.asList("Rani", "Manu");
		Stream<String> firstStream = teamA.stream();
		Stream<String> secondStream = teamB.stream();
		List<String> combined = Stream.concat(firstStream, secondStream).collect(Collectors.toList());
		System.out.println(combined);
	}

	private static void otherStreamFunctions() {

		List<String> list = Arrays.asList("Car", "Bike", "Car", "MotorCycle", "Bike");

		List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctList);

		long countDistinct = list.stream().distinct().count();
		System.out.println(countDistinct);

		List<String> limitList = list.stream().limit(2).collect(Collectors.toList());
		System.out.println(limitList);

		List<String> distinctLimit = list.stream().distinct().limit(5).collect(Collectors.toList());
		System.out.println(distinctLimit);

		List<String> mapLimitDistinct = list.stream().map(x -> x.toUpperCase()).distinct().limit(1)
				.collect(Collectors.toList());
		System.out.println(mapLimitDistinct);
		
		

		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		
		
		long maxValue = list2.stream().max((val1,val2)->{return val1.compareTo(val2);}).orElse(0);
		System.out.println(maxValue);
		
		long minValue = list2.stream().min((val1,val2) -> {return val1.compareTo(val2);
		}).orElse(0);
		
		System.out.println(minValue);
		
		
		List<String> list3 = Arrays.asList("A","B","1","2","3");
		String resultl = list3.stream().reduce((value,combinedValue) -> {
			return value+combinedValue;
		}).orElse(null);
		
		System.out.println(resultl);
		
		
		Object[] arr = list3.stream().toArray();
		System.out.println(arr);
		
		
		

	}

	private static void flatMapTest2() {

		List<String> teamA = Arrays.asList("Dheeraj", "Rahul");
		List<String> teamB = Arrays.asList("Rani", "Manu");
		List<String> teamC = Arrays.asList("Sachin", "Boysin");

		List<List<String>> playersInWordCup = Arrays.asList(teamA, teamB, teamC);
		playersInWordCup.stream().flatMap(x -> x.stream()).forEach(System.out::println);

		Product p1 = new Product(1, "abc", 10.0);
		Product p2 = new Product(2, "def", 15.0);
		Product p3 = new Product(3, "ghi", 12.0);
		Product p4 = new Product(4, "jkl", 13.0);

		List<Product> prodList = new ArrayList<>();
		prodList.add(p1);
		prodList.add(p2);

		List<Product> prodList2 = new ArrayList<>();
		prodList2.add(p3);
		prodList2.add(p4);

		List<List<Product>> prodListColection = Arrays.asList(prodList, prodList2);

		List<String> studentNames = prodListColection.stream().flatMap(x -> x.stream().map(y -> y.name))
				.collect(Collectors.toList());
		System.out.println(studentNames);

	}

	private static void flatMapTest() {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1, 2);
		List<Integer> list2 = Arrays.asList(3, 4);
		List<Integer> list3 = Arrays.asList(5, 6);

		List<List<Integer>> mainList = Arrays.asList(list, list2, list3);

		List<Integer> finalList = mainList.stream().flatMap(x -> x.stream().map(y -> y * 5))
				.collect(Collectors.toList());
		System.out.println(finalList);
	}

	private static void mapTest1() {
		List<String> names = Arrays.asList("Dheeraj", "Rahul", "Gautam", "Rani", "Mohan");
		List<String> upperNames = names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
		System.out.println(upperNames);
		List<Integer> namesLength = names.stream().map(name -> name.length()).collect(Collectors.toList());
		System.out.println(namesLength);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list.stream().map(x -> x * 3).forEach(System.out::println);

		Product p1 = new Product(1, "abc", 10.0);
		Product p2 = new Product(2, "def", 15.0);
		Product p3 = new Product(3, "ghi", 12.0);
		Product p4 = new Product(4, "jkl", 13.0);

		List<Product> prodList = new ArrayList<>();
		prodList.add(p1);
		prodList.add(p2);
		prodList.add(p3);
		prodList.add(p4);

		List<Double> filterMapList = prodList.stream().filter(p -> p.id % 2 == 0).map(x -> x.price)
				.collect(Collectors.toList());
		System.out.println(filterMapList);

	}

	private static void testFilter4() {
		Product p1 = new Product(1, "abc", 10.0);
		Product p2 = new Product(2, "def", 15.0);
		Product p3 = new Product(3, "ghi", 12.0);
		Product p4 = new Product(4, "jkl", 13.0);

		List<Product> prodList = new ArrayList<>();
		prodList.add(p1);
		prodList.add(p2);
		prodList.add(p3);
		prodList.add(p4);

		List<Product> filteredProduct = prodList.stream().filter(p -> p.price > 12.0).collect(Collectors.toList());
		System.out.println(filteredProduct);

	}

	private static void testFilter3() {
		List<String> names = Arrays.asList("Dheeraj", "Rahul", null, "Rani", null);
		List<String> namesWithoutNull = names.stream().filter(x -> x != null).collect(Collectors.toList());
		System.out.println(namesWithoutNull);

	}

	private static void testFilter2() {
		List<String> names = Arrays.asList("Dheeraj", "Rahul", "Gautam", "Rani", "Mohan");
		List<String> longNames = names.stream().filter(x -> x.length() > 6 && x.length() < 8)
				.collect(Collectors.toList());
		System.out.println(longNames);

	}

	private static void testFilter() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		List<Integer> evenNumbers = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);
		// filter takes predicate and foreach takes consumer

		list.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

	}

}
