package assignment1;

import java.util.Arrays;

public class Assignment1Pt2 {
	public static int[] ARRAY1 = {1,5,6,6,9,9,9,11,11,21};
	public static int[] ARRAY2 = {6,6,9,11,21,21,21};
	
	public static void main(String[] args) {
		int[] ARRAY3 =findSameElements(ARRAY1,ARRAY2);
		printArray(ARRAY3,4);
		

	}
	 private static int[] findSameElements(int[] arr1, int[] arr2) {
	        int a = arr1.length;
	        int b = arr2.length;
	        int[] arr3 = new int[Math.min(a, b)]; // Max number of common elements
	        int k = 0; // track the size of arr3
	        for (int i = 0; i < a; i++) {   // If element was at previous index
	            if (i > 0 && arr1[i] == arr1[i - 1]) {
	                continue;
	            }
	            // If element was not present then perform binary search over 2nd array 
	            //If true then add it to arr3
	            if (binarySearchFind(arr2, arr1[i])) {
	                arr3[k++] = arr1[i];
	            }
	        }

	        // We are creating an exact size array for common elements as number of common
	        // elements can be less than minimum of m & n
	        int[] newArray = new int[k];
	        for (int i = 0; i < k; i++) {
	            newArray[i] = arr3[i];
	        }
	        return newArray;
	    }
	 private static boolean binarySearchFind(int[] arr2, int e) {
	        int n = arr2.length;
	        int low = 0;
	        int high = n - 1;
	        
	        while (low <= high) {

	            // Calculating mid
	            int mid = low + (high - low) / 2;

	            // If element is present at mid
	            if (arr2[mid] == e) {
	                return true;
	            }
	            // If element is greater than that of mid index element
	            else if (arr2[mid] < e) {
	                low = mid + 1;
	            } else
	                high = mid - 1;
	        }
	        return false;
	    }
	 public static void printArray(int array[],int size) {
			//print the array 
					System.out.print("[");
						for(int i=0;i<size;i++) {
						System.out.print( array[i] + " ");
							}
						System.out.print("]");
		}
	
	 
}
/*
We are traversing each element of the 1st array and for each element we check that if that element
is equal to the element at previous index. If the elements are not equal then we
use binary search over 2nd array to find if the element in 1st array at
present index is present in 2nd array. If element is present in 2nd array
then binary search returns true and we add to new array. If the element at 1st
array was there in previous index then we have already performed binary
search over 2nd array for that element so, we skip. The size of 1st array is
m and that of 2nd array is n.
*/

