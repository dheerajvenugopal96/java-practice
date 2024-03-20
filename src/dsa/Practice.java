package dsa.src.dsa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
class Employee{
    
    String name;
    Integer age;
    LocalDate dob;
    String designation;
    Employee(String name,LocalDate dob,String designation){
        this.name= name;
        this.age = calculateAge(dob);
        this.designation = designation;
    }
    
    public static Integer calculateAge(LocalDate dob2){
        Integer age = 0;
        
        LocalDate today = LocalDate.now();
        
        age = today.getYear() - dob2.getYear() ;
//        System.out.println("AGe is "+age);
        
        return age;
    }
    
    
    public Integer getAge(){
        return age;
    }
    
    public String getName(){
        return name;
    }

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", dob=" + dob + ", designation=" + designation + "]";
	}
}

public class Practice {
	
	public static void main(String[] args) {
		
//		designPatterQuestion();
//
//		Map<Long,Employee> empMap = new HashMap<Long,Employee>();
//        empMap.put(1L,new Employee("Dheeraj",LocalDate.of(1996, 3, 31),"SoftwareEngineer"));
//        empMap.put(2L,new Employee("Manoj",LocalDate.of(1980, 01, 30),"SoftwareEngineer"));
//        System.out.println(empMap);
//        empMap.entrySet().stream().filter(x -> x.getValue().getAge()>30).forEach(y -> System.out.println(y.getValue().getName()));
//
//
//		int nums[] = new int[] {2,1,3};
//		Map<Character,Integer> map = new HashMap<>();
//		String a = "abcedf";
////		System.out.println(a.substring(0,3));
////		System.out.println(a.indexOf("edf"));
////		canConstruct("aab", "baa");
//		
//		String[] b = new String[200];
//		b['a']="Dog";
//		System.out.println(b[98]);
//		
//		Integer input[]=new Integer[] {0, -1, 2, -3, 1};
//		int match = -2;
//		boolean exists = twoSum2(input,match);
//		System.out.println(exists);
//		
//		
//		String s = "Hello how are you";
//		String result ="["+Arrays.asList(s.split(" ")).stream().collect(Collectors.joining("-"))+"]";
//		System.out.println(result);
//		
//		StringJoiner joiner = new StringJoiner("-", "[", "]");
//		for(String x : s.split(" ")) {
//			joiner.add(x);
//		}
//		System.out.println(joiner);
//		
//		String sstr = "dtdjydjjkl";
//
//				Map<Character,Integer> ma = new HashMap<Character,Integer>();
//
//
//				for(int i=0;i<sstr.length();i++){
//					if(ma.get(sstr.charAt(i)) != null){
//					System.out.print(sstr.charAt(i));
//				}else{
//					ma.put(sstr.charAt(i),1);
//				}
//
//				}
//				
//				Stack<String> st = new Stack<>();
//				st.push("1");
//				st.push("2");
//				st.push("3");
//				st.push("2");
//				System.out.println(st.pop());
//				System.out.println(st);
//				
//				Queue<String> q = new LinkedList<>();
//				
//				List<Integer> list = Arrays.asList(1, 2);
//				List<Integer> list2 = Arrays.asList(3, 4);
//				List<Integer> list3 = Arrays.asList(5, 6);
//				
//				List<List<Integer>> mainList = Arrays.asList(list, list2, list3);
//				List<Integer> collect = mainList.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
//				System.out.println("collect: "+collect);

//		int[] nums = new int[]{2,4,6,8};
//		int target = 5;
//		int index = binarySearch(nums,0,nums.length-1,target);

//		int a = 2;
//		int res = a^4;
//		res = res^1;
//		System.out.println(res);
//		System.out.println(res^2);

//		int[] a = new int[]{1,1,1,2,2,3};
//		int index = 2;
//		for(int i=2;i<a.length;i++){
//			if(a[i]!=a[index-2]){
//				a[index++]=a[i];
//			}
//		}

//		Set<String> currSet = new HashSet<>();
//		Set<String> prevSet = new HashSet<>();
//		currSet.add("a");
//		currSet.add("b");
//		currSet.add("c");
//		prevSet.add("a");
//		prevSet.add("b");
//		prevSet.add("c");
//		System.out.println(currSet.containsAll(prevSet));
//		System.out.println(currSet.equals(prevSet));
//
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.set(1,5);
//
//		System.out.println(list);

//		int[][] matrix = new int[2][9];
//		System.out.println(matrix.length);
//		System.out.println(matrix[0].length);
//		int result = 0;
//		Stack<Integer> stack = new Stack();
//		String[] tokens= new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//		for(String str : tokens){
//			if(str.charAt(0)=='+'){
//				stack.push(stack.pop()+stack.pop());
//			}else if(str.charAt(0)=='-'){
//				int ele1 = stack.pop();
//				int ele2 = stack.pop();
//				stack.push(ele2 - ele1);
//			}else if(str.charAt(0)=='*'){
//				stack.push(stack.pop()*stack.pop());
//			}else if(str.charAt(0)=='/'){
//				System.out.println(stack.size());
//
//				int ele1 = stack.pop();
//				int ele2 = stack.pop();
//				stack.push(ele1/ele2);
//
//			}else{
//				stack.push(Integer.parseInt(str));
//			}
//		}
//		Map<Integer,Integer> map = new HashMap<>(2);
//		map.put(1,1);
//		map.put(2,2);
//		System.out.println(map.size());
//		Queue queue = new LinkedList();

//		int preorder[] = new int[]{3,9,20,15,7};
//		int inorder[] = new int[]{9,3,15,20,7};
//		Map<Integer,Integer> map = new HashMap<>();
//		for(int i=0;i<inorder.length;i++){
//			map.put(inorder[i],i);
//		}
//
//		TreeNode root =  buildTree(preorder,map,0,0,inorder.length-1);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        Integer result = integerList.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().orElse(0);
        System.out.println(result);

	}

	private static TreeNode buildTree(int[] preorder,Map<Integer,Integer> map,
									  int rootIndex,int left,int right) {
		TreeNode root = new TreeNode(preorder[rootIndex]);
		int mid = map.get(preorder[rootIndex]);
		if(mid>left)
			root.left = buildTree(preorder,map,rootIndex+1,left,mid-1);
		if(mid<right)
			root.right = buildTree(preorder,map,rootIndex+mid-left+1,mid+1,right);

		return root;

	}

	private static int binarySearch(int[] nums,int left,int right,int target){
		if(left>right){
			return left;
		}

		int mid = (left+right) /2 ;

		if(nums[mid]==target){
			return mid;
		}


		if(target < nums[mid]){
			return binarySearch(nums,left,mid-1,target);
		}

		return binarySearch(nums,mid+1,right,target);
	}

	private static void designPatterQuestion() {
		int n = 20;
		int numLines = n*2-1;
		int numbersForEachLine=1;
		for(int i = 1;i<=numLines;i++) {
			int start = n;
			int k = numLines;
			//first print the leading *'s if any
			for(int j=0;j<(numLines-numbersForEachLine)/2;j++) {
				System.out.print("*");
				k--;
			}
			
			//second print the numbers
			for(int j=0;j<numbersForEachLine;j++) {
				System.out.print(start);
				if(j<numbersForEachLine/2) {
					start--;
				}else {
					start++;
				}
				k--;
			}
			
			//print the trailing starts if any
			for(int j=0;j<k;j++) {
				System.out.print("*");
			}
			
			
			
			//ending logic
			if(i<numLines/2+1)
			numbersForEachLine+=2;
			else
			numbersForEachLine-=2;
			System.out.println();


		}
	}
	
	//x+y = sum
	//sum-x = y;
	
	private static boolean twoSum2(Integer[] input,int match) {
		Arrays.sort(input);
		int i = 0;
		int j = input.length-1;
		while(i<j) {
			int sum = input[i]+input[j];
			if(sum<match) {
				i++;
			}else if(sum>match) {
				j--;
			}else {
				return true;
			}
		}
		
		return false;
	}
	
	//{0, -1, 2, -3, 1}
	//{-3,-1,0,1,2}
	//-3+2 = -1 > -2 then reduce from back
	//-3+1 = -2 == -2 //found match
	
	private static boolean twoSum(Integer[] input, int match) {
		for(int i =0;i<input.length;i++) {
			for(int j=i+1;j<input.length;j++) {
				if(input[i]+input[j]==match) {
					return true;
				}
			}
		}
		return false;
		
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
	       int[] alphabet = new int[26];

	        for (char c : ransomNote.toCharArray()) {
	            int i = magazine.indexOf(c, alphabet[c % 26]);
	            if (i == -1) {
	                return false;
	            }
	            alphabet[c % 26] = i + 1;
	        }

	        return true;
	    }

}

interface A{
	void show();
}

interface B extends A{
	void noshow();
}

class C implements B{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noshow() {
		// TODO Auto-generated method stub
		
	}
	
}

@FunctionalInterface
interface D  {
	void hello();
	
	default void hi() {
		
	}
	
	static void yo() {
		
	}
}

@FunctionalInterface
interface E extends A{
	
}
