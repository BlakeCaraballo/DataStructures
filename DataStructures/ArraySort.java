package lab3;

import java.util.Arrays;

public class ArraySort {


	public static void main(String[] args) {
		int[] array = {0,1,1,0,1,2,1,2,0,0,0,1};
		sort(array);

	}
	
	static void sort(int[] arr)
	{
		int a,b,temp, comparisonsToMake;
		comparisonsToMake = arr.length-1;
		
		for(a=0; a<comparisonsToMake;a++) {
			for(b=0;b < comparisonsToMake;b++) 	//run the sort length-1, in this case 11 times.
			if(arr[b] > arr[b+1]) { 			//if the first is > the second, swap them.
				temp = arr[b];				
				arr[b]=arr[b+1];        		
				arr[b+1]=temp;
				//System.out.println(Arrays.toString(arr)); //check how many times it has run
			}
		}
		comparisonsToMake--;                   	//decrement after each pass
		
		System.out.println(Arrays.toString(arr)); 	//check final output
		
	}

}
