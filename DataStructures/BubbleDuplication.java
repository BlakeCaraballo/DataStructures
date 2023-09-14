package lab5;

import java.util.Arrays;
import java.util.Scanner;


public class BubbleDuplication {
	static int[] someNums = {50,11,33,21,40,50,40,40,21};
	static int comparisonsToMake = someNums.length-1; // controls how many comparisons are made
	static int temp;
	static int b;
	static int a;
	
	public static void printArray(int array[],int size) {
		//print the array with no duplicates
				System.out.print("[");
					for(int i=0;i<size;i++) {
					System.out.print( array[i] + " ");
						}
					System.out.print("]");
	}


	public static int[] removeDuplicates(int array[], int length) {
		int[] newArray = new int[length]; //make a new array
		newArray[0] = array[0];			  //set index 0 of new array = to the array you're removing duplicates of
		int index = 1;                   //index counter
		for(int i = 1;i < length;i++) {
			if(array[i] != array[i-1]) { //if the index next to the current index are not equal to each other
				newArray[index++]=array[i]; //continue filling up the array with the original values
			}
		}
		//System.out.println(Arrays.toString(newArray));
		
		return newArray; //return number of elements in the new array
		}
	
	public static void bubbleSort(int arr[]) {
		for(a=0; a<comparisonsToMake;a++) {
			for(b=0;b < comparisonsToMake;b++) 	//run the sort length-1
			if(someNums[b] > someNums[b+1]) { 	//if the first is > the second, swap them.
				temp = someNums[b];				//how to swap them
				someNums[b]=someNums[b+1];
				someNums[b+1]=temp;
			}
		}
		comparisonsToMake--;                   	//decrement after each pass
		System.out.println(Arrays.toString(someNums));
	}

	public static void main (String[] args) {
		bubbleSort(someNums);    //bubble sort original array
		int size=5;
		int[] noDup = removeDuplicates(someNums,9);  //create a second array with no duplicates
	    printArray(noDup,size); //print new array
		
	
	}
	//test cases:
	//an empty array would not work for my solution because i have some values hard coded
	//i would need to put it in a try/catch block, make the array user input and ask them to put at least 1 value
	//input can be of any length in my solution, such that you know the length beforehand
	//input mismatch would need to be handled in a try/catch as well
	//index out of bounds wouldn't be an issue if i didn't hard code the length and size variables
}