package finalexam;
import java.util.HashMap;

public class hashStructure {

	public static void main(String[] args) {
		int array[] = {1,2,3,4,4,6,6,6}; //starting array
		
		HashMap<Integer,Integer> map = new HashMap<>(); //hashmap for storing unique values
		
		for(int i = 0; i < array.length-1;i++) { //iterating over the array 
			if(map.containsKey(array[i])) {//if the array contains duplicates, remove them
				map.remove(array[i]);
			}
			map.put(array[i],i); // if the number is unique then put it in the map, using the index as the key
		}
			map.forEach((k,v) -> System.out.print(k + " "));//printing new array with only unique values
	}

}
 