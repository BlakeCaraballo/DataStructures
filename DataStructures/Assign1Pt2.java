package assignment1;

import java.util.Scanner;

public class Assign1Pt2 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Enter size of 1st array
	        System.out.println("Enter size of 1st array: ");
	        int m = sc.nextInt();
	        int[] array1 = new int[m];
	        // Enter elements in 1st array
	        System.out.println("Enter elemnets in the 1st array");
	        for (int i = 0; i < m; i++) {
	            array1[i] = sc.nextInt();
	        }

	        // Enter size of second array
	        System.out.println("Enter size of 2nd array");
	        int n = sc.nextInt();
	        int[] array2 = new int[n];
	        // Enter elements of 2nd array
	        System.out.println("Enter elements in the 2nd array");
	        for (int i = 0; i < n; i++) {
	            array2[i] = sc.nextInt();
	        }

	        // Finding common elements
	        int[] array3 = findCommonElements(array1, array2);
	        if (array3.length == 0) {
	            // If no common elements were found
	            System.out.println("No common elements found");
	        } else {
	            System.out.println("Common elements are");
	            for (int ele : array3) {
	                System.out.print(ele + "  ");
	            }
	            System.out.println();
	        }
	        sc.close();
	    }
	 
	 private static int[] findCommonElements(int[] array1, int[] array2) {
	        int m = array1.length;
	        int n = array2.length;
	        int[] array3 = new int[Math.min(n, m)]; // Maximum number of common elements is minimum of m, n
	        int k = 0; // To track the size of new array
	        for (int i = 0; i < m; i++) {
	            // If element was present at previous index
	            if (i > 0 && array1[i] == array1[i - 1]) {
	                continue;
	            }
	            // If element was not present then perform binary search over 2nd array for
	            // current index element. If it returns true then add it.
	            if (binarySearchFind(array2, array1[i])) {
	                array3[k++] = array1[i];
	            }
	        }

	        // We are creating an exact size array for common elements as number of common
	        // elements can be less than minimum of m & n
	        int[] answrArray = new int[k];
	        for (int i = 0; i < k; i++) {
	            answrArray[i] = array3[i];
	        }
	        return answrArray;
	    }
	 private static boolean binarySearchFind(int[] array2, int ele) {
	        int n = array2.length;
	        int low = 0, high = n - 1;
	        while (low <= high) {

	            // Calculating mid
	            int mid = low + (high - low) / 2;

	            // If element is present at mid
	            if (array2[mid] == ele) {
	                return true;
	            }
	            // If element is greater than that of mid index element
	            else if (array2[mid] < ele) {
	                low = mid + 1;
	            } else
	                high = mid - 1;
	        }
	        return false;
	    }
	

}

