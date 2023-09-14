package lab9;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dequeue {
	 //creating a queue and dequeue
    Queue<Integer> q;
    ArrayDeque<Integer> dq;

    //constructor for the class
    Dequeue() {
        q = new LinkedList<>();
        dq = new ArrayDeque<>();
    }

    void enqueue(int data){
        //find the correct position of the element in the dequeue and insert it there
        while(!dq.isEmpty() && dq.getLast() < data){
            //remove the last element from dequeue
            dq.removeLast();
        }
        //add the element at the end
        dq.addLast(data);
        q.add(data);
    }

    void deque(){
        //return the last element of the dequeue
        if(dq.getFirst() == q.peek()){
            dq.removeFirst();
        }
        q.remove();
    }

    //get the maximum element from the queue
    int getMax() throws Exception{
        //check if the element is empty
        if(q.isEmpty())
            throw new Exception("Queue is Empty");
        else
            return dq.getFirst();
    }

    //test method
    public static void main(String[] args) throws Exception {
        Dequeue dq = new Dequeue();
        while(true){
            System.out.println("Menu Options ");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Get Max");
            System.out.println("4. Quit");
            
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Enter the element");
                int n = sc.nextInt();
                dq.enqueue(n);
            }
            else if(choice == 2){
                System.out.println("Element is removed");
                dq.deque();
            }else if(choice == 3){
                System.out.println("The max-element is " + dq.getMax());
            }else if(choice == 4){
                break;
            }
        }
    }
}