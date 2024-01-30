package dsa;

import java.util.Scanner;

public class StringReverse {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String word = in.nextLine();
		String[] arr = new String[word.length()];
		arr = word.split("");
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
	}

}
