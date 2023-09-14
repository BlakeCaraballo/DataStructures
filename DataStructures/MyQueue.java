package lab9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	   Queue<Integer> mainQueue;
	   Deque<Integer> maxQueue;

	    public static void main(String[] args) throws Exception {
	        MyQueue queue = new MyQueue();
	        queue.addToQueue(5);
	        queue.addToQueue(3);
	        queue.addToQueue(4);
	        queue.addToQueue(1);
	        queue.addToQueue(2);
	        System.out.println(queue);

	        System.out.println("\nThe maximum element in the queue is: " + queue.getMax());

	        System.out.println("\nRemoving the first two elements from the queue...");
	        queue.dequeue();
	        queue.dequeue();
	        System.out.println("\nThe new max element in the queue is: " + queue.getMax());
	    }
	    
	    //constructor
	    public MyQueue() {
	        mainQueue = new LinkedList<>();
	        maxQueue = new ArrayDeque<>();
	    }

	    //method for adding to the queue
	    public void addToQueue(int data) {
	        while (!maxQueue.isEmpty() && maxQueue.getLast() < data) {
	            maxQueue.removeLast();
	        }
	        maxQueue.addLast(data);
	        mainQueue.add(data);
	    }

	    //method for removing from the queue
	    public void dequeue() {
	        if (maxQueue.getFirst().equals(mainQueue.peek())) {
	            maxQueue.removeFirst();
	        }
	        mainQueue.remove();
	    }

	    //method to get the max value of the queue
	    public int getMax() {
	        if (mainQueue.isEmpty())
	            throw new IndexOutOfBoundsException("Queue is Empty");
	        else
	            return maxQueue.getFirst();
	    }

	    @Override
	    public String toString() {
	        return "The queue elements are: \n" + mainQueue;
	    }


	}


//test cases:

//if queue is empty then i made the getMax function throw an error 
//throw new IndexOutOfBoundsException("Queue is Empty");
//to remove the last element i would create a method called remove or use Stack.remove();
//to handle invalid objects i would put the whole thing in a try catch 
//to remove objects i would use the Stack.Remove(Object) method
//to avoid memory leaks i would make sure everything is popped out of the stack before exiting the code


