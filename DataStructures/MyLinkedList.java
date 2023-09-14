package lab7;

public class MyLinkedList 
{
	public class Node {
		int data; // can be any data type
		Node next; 
	}
	
	Node head;
	
	
	public void insert(int data) //adds data to the end of the list
	{
		Node node = new Node(); //create node
		node.data = data; 		// set the inputed data to the node
		node.next = null;		//the next node in the list is null
		
		if(head == null)   	 	// check if this is the first node in the list
		{
			head = node;
		}
		else					// if it isn't, add it to the end
		{
			Node n = head;
			while(n.next != null)
			{
				n = n.next;
			}
			n.next = node;
			
		}	
	}
	
	public void show()		//prints all elements of linked list
	{
		Node node = head;	//create head node
		
		while(node.next!=null)	// traverse through list
		{
			System.out.println(node.data);	//print first node's data
			node = node.next;				//move to next node and repeat printing until false
		}
		System.out.println(node.data); // last reference wont be printed inside the loop b/c refers to null
		System.out.println();
	}
	
	public void deleteThirdLastNode()
    { 
        Node current=head;
        Node prev=head;
     
        while(current.next.next.next!=null)
        {
           
            prev = current;
            current = current.next;
            
        }
        prev.next = current.next;
        
    }
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(1);
		linkedList.insert(7);
		linkedList.insert(5);
		linkedList.insert(18);
		
		linkedList.show();
		linkedList.deleteThirdLastNode();
		linkedList.show();

	}
	
	
}

