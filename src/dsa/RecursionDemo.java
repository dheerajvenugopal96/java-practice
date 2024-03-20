package dsa.src.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionDemo {

    public static void main(String[] args) {

        RecursionDemo main = new RecursionDemo();
        RecursionDemoSub recur = main.new RecursionDemoSub();

        recur.printSubsequences(new int[]{3,1,2},0,new ArrayList<Integer>());
    }

    class RecursionDemoSub{

        //print all subsequences in order

        public static void printSubsequences(int[] arr, int index,List<Integer> list){
            if(index>=arr.length){
                System.out.println(list);
                return;
            }
            list.add(arr[index]);

            //pick condition
            printSubsequences(arr,index+1,list);
            list.remove(list.size()-1);

            //do not pick condition
            printSubsequences(arr,index+1,list);
        }

        //reverse an array
        public static int[] reverseArr(int[] arr,int left,int right){

            if(left>=right){
                return arr;
            }

            int temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            return reverseArr(arr,left+1,right-1);

        }


        public static int factorial(int n){
            if(n==1){
                return 1;
            }
            return n*factorial(n-1);
        }

        private static void printReverse(int i, int n) {
            if(i>n){
                return;
            }
            printReverse(i+1,n);
            System.out.println(i);
        }

        private static int sumOfNaturalNumbers(int i) {

            if(i<=1){
                return i;
            }

            return i + sumOfNaturalNumbers(i-1);

        }

        private static String convertDecimalToBinary(Integer number, String binaryResult) {
            if(number==0){
                return binaryResult;
            }

            binaryResult = number%2+binaryResult;
            return convertDecimalToBinary(number/2,binaryResult);
        }

        private static boolean checkPalindrome(String input) {
            if(input.length()==0 || input.length()==1){
                return true;
            }

            if(input.charAt(0)==input.charAt(input.length()-1)){
                return checkPalindrome(input.substring(1,input.length()-1));
            }

            return false;
        }

        private static String reverseString(String line) {
            if(line==""){
                return "";
            }

            return reverseString(line.substring(1))+line.charAt(0);
        }
    }


}
