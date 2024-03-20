package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student3 {
	String name;
	int id;
	int marks;

	public Student3(String name, int id, int marks) {
		super();
		this.name = name;
		this.id = id;
		this.marks = marks;
	}
	
	public int getMarks() {
		return marks;
	}

}

class Products{
	String category;
	Double price;
	public Products(String category, Double price) {
		super();
		this.category = category;
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class EvenOddCollector implements Collector<Integer, Map<Boolean,List<Integer>>, Map<Boolean,List<Integer>>>{

	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		
		return () -> new HashMap<Boolean,List<Integer>>(){{
		put(true, new ArrayList<>()); //for even
		put(false, new ArrayList<>()); //for odd
		}};
	}

	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		// TODO Auto-generated method stub
		return (acc,number) -> acc.get(number%2==0).add(number);
	}

	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		// TODO Auto-generated method stub
		
		//for parallel scenarios
		return (acc1,acc2) -> {
			acc1.get(true).addAll(acc2.get(true));
			acc1.get(false).addAll(acc2.get(false));
			return acc1;
		};
		
		//for non-parallel or sequential scenarios you can simple do 
		//(acc1,acc2) -> acc1;
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		// TODO Auto-generated method stub
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return Collections.EMPTY_SET;
	}
	
}

class FibonacciSequence implements Supplier<Long>{

	private long previous = 0;
	private long current = 1;
	
	@Override
	public Long get() {
		long next = previous + current;
		previous = current;
		current = next;
		return previous;
	}
	
}

public class StreamPracticeQuestions {

	public static void main(String[] args) {

//		findSum();
//		findAverage();
//		findSquareFilterAverage();
//		findOddEven();
//		findNumbersStartingWith2();
//		findDuplicateNumbers();
//		findMaxAndMin();
//		sortNumbers();
//		limitAndSum();
//		secondLowestAndHighestNumber();
//		Student3WithTheSecondHighestMark();
//		convertListToMap();
//		reuseStreams();
//		duplicateCountInString();
//		countOccurences();
//		customCollector();
//		countParallel();
		
//		groupAndAverage();
//		combiningStreams();
//		distinctPairs();
//		findingPatterns();
//		customSorting();
//		reducingWithCustomCombiner();
//		firstNonRepeatedCharacter();
//		findMaxOccurance();
//		fibonacciUsingStreamsUsingSupplierSyntax();
		fibonacciStreamsUsingStreamIterator();
	}
	
	

	private static void fibonacciStreamsUsingStreamIterator() {

		Stream<Long> iterate = Stream.iterate(new long[] {1,1},n-> new long[] {n[1],n[0]+n[1]}).map(n->n[0]);
		Stream.iterate(1,n -> (n-1)+(n+1)).limit(10).forEach(System.out::print);
//		iterate.limit(10).forEach(System.out::print);
		
	}



	private static void fibonacciUsingStreamsUsingSupplierSyntax() {
		
		Stream<Long> fibStream = Stream.generate(new FibonacciSequence());
		
		fibStream.limit(10).forEach(System.out::print);
		
	}



	private static void findMaxOccurance() {
		String str = "ABBABACDABDCAA";
		
		Optional<Entry<Character, Long>> collect = str.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(y -> y, Collectors.counting())).entrySet().stream()
				.collect(Collectors.maxBy(Comparator.comparingLong(x -> x.getValue())));

		System.out.println(collect.get());
		
	}



	private static void firstNonRepeatedCharacter() {
		String s = "Java language Alive is Awesome";
		List<Character> list = new ArrayList<>();
		Character key = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(y -> y.getValue() == 1).findFirst().get().getKey();
		System.out.println(key);	
		
	}



	private static void reducingWithCustomCombiner() {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("Dheeraj","Rahul","Rohan","Mandy","Siva");
		String result = list.stream().collect(Collectors.reducing((ele1,ele2) -> ele1+","+ele2)).get();
		System.out.println(result);
	}



	private static void customSorting() {
		/*
		 * Given a list of objects with name and age attributes, use Java 8 Streams to
		 * sort the objects first by age in descending order and then by name in
		 * ascending order.
		 */
		List<Person> persons = Arrays.asList(
                new Person("Alice", 28),
                new Person("Bob", 35),
                new Person("Charlie", 25),
                new Person("David", 35)
        );

		List<Person> collect = persons.stream().sorted((p1,p2)->{
			
			int ageComparison = Integer.compare(p2.getAge(), p1.getAge());
			if(ageComparison!=0) {
				return ageComparison;
			}
			
			return p1.getName().compareTo(p2.getName());
		}).collect(Collectors.toList());
		
		System.out.println(collect);
	}



	private static void findingPatterns() {
		/*
		 * Given a list of strings, find and print the first two strings that contain
		 * the substring "Java" and have a length greater than 5.
		 */
		
		List<String> list = Arrays.asList("Java is awesome","abc","Java is great","Java is simple");
		List<String> collect = list.stream().filter(x -> x.length()>5 && x.contains("Java")).limit(2).collect(Collectors.toList());
		System.out.println(collect);
	}



	private static void distinctPairs() {
		// TODO Auto-generated method stub
		/*  Given a list of integers, find all distinct pairs of numbers whose sum is divisible by 3.

*/
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		List<List<Integer>> collect = list.stream()
				.flatMap(x -> list.stream().filter(j -> !x.equals(j)).map(j -> Arrays.asList(x, j)))
				.distinct()
				.filter(pair -> (pair.get(0) + pair.get(1)) % 3 == 0)
				.collect(Collectors.toList());
		System.out.println(collect);
		
	}



	private static void combiningStreams() {
		// TODO Auto-generated method stub
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        
        List<Integer> collect = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(collect);
		
	}



	private static void groupAndAverage() {
		/*
		 * Given a list of objects with a category attribute, group the objects by
		 * category and calculate the average price for each category.
		 */
		
		Products p1 = new Products("phone", 12d);
		Products p2 = new Products("phone",11d);
		Products p3 = new Products("laptop",10d);
		Products p4 = new Products("laptop",10d);
		List<Products> list = Arrays.asList(p1,p2,p3,p4);
		
		Map<String,Double> result =list.stream().collect(Collectors.groupingBy(Products::getCategory,Collectors.averagingDouble(Products::getPrice)));
		System.out.println(result);
		
	}



	private static void countParallel() {
		List<String> list = Arrays.asList("apple","banana","apple","grapes","orange");
		Map<String,Long> result =list.parallelStream().collect(Collectors.groupingByConcurrent(word -> word,Collectors.counting()));
		System.out.println(result);
		
	}



	private static void customCollector() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
		Map<Boolean,List<Integer>> result = list.stream().collect(new EvenOddCollector());
		System.out.println("Even Numbers: "+result.get(true));
		System.out.println("Odd Numbers: "+result.get(false));
		//even numbers should be collected in a set and odd numbers in a list
		
		
	}

	private static void countOccurences() {
		List<Integer> list = Arrays.asList(1,2,3,4,4,5,6,7,7,8,9,9);
		Map<Integer,Long> map = list.stream().collect(Collectors.groupingBy(x -> x,Collectors.counting()));
		System.out.println(map);
		
		List<String> list2 = Arrays.asList("Ram","Gopal","Verma","Ram");
		Map<String,Long> map2 = list2.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
		System.out.println(map2);
		
	}

	private static void duplicateCountInString() {
		String s = "hello hello";

		// find count of vowels
		long result = s.chars().filter(x -> {
			return (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u');
		}).count();

		System.out.println(result);

		// find duplicates
		String str = "Hello hi my hi is my Dheeraj";
		List<String> stringList = Arrays.asList(str.split(" "));
		Set<String> duplicates = stringList.stream().filter(x -> Collections.frequency(stringList, x) > 1)
				.collect(Collectors.toSet());
		System.out.println(duplicates);
		
		//print count of elements in s 
		Map<Object,Long> map = s.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Object::toString,Collectors.counting()));
		map.forEach((k,v)-> System.out.println(k+":"+v));
	
	}

	private static void reuseStreams() {

		String[] arr = { "Hello", "hi", "Hola", "Aloha", "Hello" };
		Stream<String> inputStream = Arrays.asList(arr).stream();
		inputStream.forEach(System.out::println);
//		long count = inputStream.filter(x -> "Hello".equals(x)).count(); --> error as stream is closed so cannot be operated on
//		System.out.println(count);

		Supplier<Stream<String>> ipStream = () -> Stream.of(arr);
		long count = ipStream.get().filter(x -> "Hello".equals(x)).count();
		System.out.println(count);

	}

	private static void convertListToMap() {
		Student3 s1 = new Student3("Dheeraj", 1, 10);
		Student3 s2 = new Student3("Rani", 2, 20);
		Student3 s3 = new Student3("Baby", 3, 30);
		Student3 s4 = new Student3("Arjun", 4, 25);
		Student3 s5 = new Student3("Kiran", 1, 9);
		Student3 s6 = new Student3("Kiran", 5, 10);
		List<Student3> studList = Arrays.asList(s1, s2, s3, s4, s5, s6);

		/*
		 * Map<String, Student3> studentMap =
		 * studList.stream().collect(Collectors.toMap(x -> x.name, x -> x));
		 * System.out.println(studentMap);
		 */

		// Group a stream by some valuek
		Map<String, List<Student3>> studentListMap = studList.stream().collect(Collectors.groupingBy(x -> x.name));
		System.out.println(studentListMap);
	}

	private static void Student3WithTheSecondHighestMark() {
		// TODO Auto-generated method stub
		Student3 s1 = new Student3("Dheeraj", 1, 10);
		Student3 s2 = new Student3("Rani", 2, 20);
		Student3 s3 = new Student3("Baby", 3, 30);
		Student3 s4 = new Student3("Arjun", 4, 25);
		Student3 s5 = new Student3("Kiran", 1, 9);
		List<Student3> studList = Arrays.asList(s1, s2, s3, s4, s5);
		int highestMark = studList.stream().map(x -> x.marks).sorted(Collections.reverseOrder()).skip(1).findFirst()
				.get();
		
		//to get the Student instead of the mark
		Student3 secondHighest = studList.stream().sorted(Comparator.comparing(Student3::getMarks).reversed()).skip(1)
				.findFirst().get();
		System.out.println(highestMark);

	}

	private static void secondLowestAndHighestNumber() {
		List<Integer> numbers = Arrays.asList(2, 22, 345, 532, 222, 23, 3452, 222, 23, 542);
		int secondLowest = numbers.stream().sorted().distinct().skip(1).findFirst().get();
		int secondHighest = numbers.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
		System.out.println("Second lowest : " + secondLowest + " Second highest :" + secondHighest);

	}

	private static void limitAndSum() {
		List<Integer> numbers = Arrays.asList(2, 22, 345, 532, 222, 23, 3452, 222, 23, 542);
		int sum = numbers.stream().limit(5).mapToInt(x -> x).sum();
		System.out.println(sum);

		sum = numbers.stream().skip(5).reduce((x, y) -> x + y).get();
		System.out.println(sum);

	}

	private static void sortNumbers() {
		List<Integer> numbers = Arrays.asList(2, 22, 345, 532, 222, 23, 3452, 222, 23, 542);
		List<Integer> result = numbers.stream().sorted().collect(Collectors.toList());
		System.out.println(result);
		result = numbers.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(result);

	}

	private static void findMaxAndMin() {
		List<Integer> numbers = Arrays.asList(2, 22, 345, 532, 222, 23, 3452, 222, 23, 542);
		int max = numbers.stream().max((val1, val2) -> {
			return val1.compareTo(val2);
		}).get();
		int min = numbers.stream().min((val1, val2) -> {
			return val1.compareTo(val2);
		}).get();
		System.out.println("Max: " + max + " Min:" + min);

	}

	private static void findDuplicateNumbers() {
		List<Integer> numbers = Arrays.asList(2, 22, 345, 532, 222, 23, 3452, 222, 23, 542);
		Set<Integer> duplicates = numbers.stream().filter(x -> Collections.frequency(numbers, x) > 1)
				.collect(Collectors.toSet());
		System.out.println(duplicates);

		// SEcond way
		Set<Integer> duplicatesNumber = new HashSet<>();
		Set<Integer> result2 = numbers.stream().filter(e -> !duplicates.add(e)).collect(Collectors.toSet());
		System.out.println(result2);

	}

	private static void findNumbersStartingWith2() {
		List<Integer> numbers = Arrays.asList(2, 22, 345, 532, 222, 23, 3452);
		List<Integer> result = numbers.stream().map(String::valueOf).filter(x -> x.startsWith("2"))
				.map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(result);
	}

	private static void findOddEven() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> result = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(result);
	}

	private static void findSquareFilterAverage() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Double average = list.stream().map(x -> x * x).skip(2).mapToInt(y -> y).average().getAsDouble();
		System.out.println(average);

	}

	private static void findAverage() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5);
		Double average = list.stream().mapToInt(x -> x).average().getAsDouble();
		Double average2 = list.stream().collect(Collectors.averagingDouble(x -> x));
		System.out.println(average);
		System.out.println(average2);

	}

	private static void findSum() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5);
		int sum = list.stream().mapToInt(x -> x).sum();
		System.out.println(sum);

	}

}
