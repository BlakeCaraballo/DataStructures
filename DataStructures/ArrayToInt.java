package lab3;

public class ArrayToInt {

	public static void main(String[] args) {
		int[] array = {1,9,8,9};
		System.out.println(numPlusOne(array));
	}
	
	static int numPlusOne(int arr[])
	{
		int num = 0;                       //initialize num to zero
		for(int i = 0; i<arr.length; i++)  // iterate over the array
		{
			num*=10;                       //multiply num by 10 to move from 1,10,100,1000 position in number
			num+=arr[i];                   //add the new digit to num(1,19,198,1989) 
		}
		return num;                      //return the array+1 as an int
	}

}
