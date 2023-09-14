package assignment1;

import java.util.Arrays;

public class Assignment1 {
	public static int[] ARRAY1 = {1,5,6,6,9,9,9,11,11,21};
	public static int[] ARRAY2 = {6,6,9,11,21,21,21};
	public static int x = ARRAY1.length; //made this a variable to make it easier to read
	public static int y = ARRAY2.length; //made this a variable to make it easier to read
	public static int count = 0; //counts number of elements in ARRAY3
	public static int size = x > y ? y : x; //smaller of the two original arrays will be the max size of ARRAY3
	public static int[]ARRAY3 = new int[size];
	public static boolean exists = false; //used to check if a number already exists in the array
	
	public static void main(String[] args) {
	int[] noDup1 =removeDuplicates(ARRAY1,x);
	printArray(noDup1,6); // first array without duplicates
	
	int[] noDup2 =removeDuplicates(ARRAY2,y);
	printArray(noDup2,4); //second array without duplicates
	
    ARRAY3 =arrayCompare(noDup1,noDup2);
    printArray(ARRAY3,4);//third array which compares the first two and prints what they have in common
	}
	
	public static void printArray(int array[],int size) {
		//print the array 
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
	
		return newArray; //return number of elements in the new array
	}
	
	public static int[] arrayCompare(int[] a,int[] b) {
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<b.length; j++)
			if(a[i] == b[j]) { //if an element in the first two arrays are equal
				for(int k = 0; k<count;k++) { //check if the value already exists
					if(a[i]==ARRAY3[k]) {
						exists = true;
						break;
					}
				}
				if(exists == false) { //if the value doesn't already exist
					ARRAY3[count++] = a[i];
					break;
				}
				exists = false;
				}
			}
		return ARRAY3;
	}
	

	}


 