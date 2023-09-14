package finalexam;

public class BST {
	
	static class Node{
		int data;
		Node left, right;
		
		public Node(int item) {
			data = item;
			left = null;
			right = null;
		}
	}
	
	Node root;
	
	//returns the third smallest element
	public int returnThirdSmallest() {
		return findThirdSmallest(root, 0);
	}

	//recursively find the third smallest element
	public int findThirdSmallest(Node temp, int count) {
		if (temp == null)
			return -1;
		int val = findThirdSmallest(temp.left, count);
		if (val != -1) {
			return val;
		}
		if (count == 2) {
			return temp.data;
		} else {
			count++;
		}
		return findThirdSmallest(temp.right, count + 1);

	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		System.out.println("The third smallest element is "+tree.returnThirdSmallest());
	}
}