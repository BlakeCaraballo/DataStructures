package midterm;

public class BinarySearch {
	public static void main(String[] args) {
		int array [] = {11,21,33,40,50};
		
		//storing the index of the number if found and -1 if not found
		int result =binarySearch(array,0,array.length-1,50); //change last argument to change search value
		
		if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+ result);
	}
	public static int binarySearch(int[] arr, int low, int high, int key) {
		//calculate the midpoint value
		int mid = low+(high-low);
		
		//if the array is unsorted
		if(low>high) {
			return -1;
		}
		
		//if the key is already at midpoint
		if(arr[mid]==key) {
			return mid;
		}
		
		//if the key is less than the midpoint,recursively 
		//binary search the left half of the array
		if(key < arr[mid]) {
			return binarySearch(arr,low,mid-1,key);
		}
		
		//if the key is greater than the midpoint,recursively 
		//binary search the right half of the array
		if(key > arr[mid]) {
			return binarySearch(arr,mid+1,high,key);
		}
		//if the value isn't found
		return -1;
	}
}
