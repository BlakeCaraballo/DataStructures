package midterm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = {50,11,33,21,40,50,40,40,21};
		quickSort(nums);
		printArray(nums);

	}
	
	public static void quickSort(int[] array, int lowIndex, int highIndex) {
	//the base case, where there is an array of only one element
		if(lowIndex >= highIndex) {
			return;
	}
	//select a random number from the array to be the pivot
	//if you select the last element each time it will be slower in some cases
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = array[pivotIndex];
	
		swap(array,pivotIndex,highIndex);
	
	//left pointer starts on left side and moves right
		int leftPointer = partition(array, lowIndex, highIndex, pivot);
	
	//recursively quicksort the sub-arrays 
		quickSort(array,lowIndex,leftPointer-1);
		quickSort(array,leftPointer+1,highIndex);
}
	public static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
	//left pointer starts at 0, right pointer starts at the last element
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
	
		while(leftPointer < rightPointer) {
		//moving left pointer right and right pointer left
			while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
			leftPointer++;
			}
			while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
			rightPointer--;
			}
		//bring left and right closer and closer until they meet, and swap
			swap(array,leftPointer,rightPointer);
	}
	//when they meet, swap pivot with the left pointer 
		swap(array,leftPointer,highIndex);
		return leftPointer;
}

//method for swapping elements
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
}

//overloaded method with same name to make it easier to call the method in main
	public static void quickSort(int[] array) {
		quickSort(array,0,array.length-1);
}

//method for printing the array 
	public static void printArray(int array[]) {
		System.out.print("[");
			for(int i=0;i<array.length;i++) {
			System.out.print( array[i] + " ");
					}
			System.out.print("]");
    }


}

