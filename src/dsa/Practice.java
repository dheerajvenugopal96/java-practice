package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Practice {
	
	public static void main(String[] args) {
		
		designPatterQuestion();
		
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
