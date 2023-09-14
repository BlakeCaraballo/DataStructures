package lab8;

import java.util.Scanner;
import java.util.Stack;

public class SimpleCalc {
	public static void main(String[] args) {
		String expression;

		//Scanner object for user input
		Scanner scan = new Scanner(System.in);

		//prompting user for a postfix expression
		System.out.println("Enter a postfix expression: ");
		expression = scan.nextLine();

		//Evaluating expression and printing the result
		System.out.println(expression + " = " + PostFixEval(expression));
		
		scan.close();
	}

		//Method that evaluates a postfix expression
	public static double PostFixEval(String postfixExpr) {

		//Stack to hold double values
		Stack<Double> stack = new Stack<Double>();

		//Splitting on space
		String[] items = postfixExpr.split(" ");

	double value1, value2;

		//Iterate over split items
	for(int i=0; i<items.length; i++)
		{
		//Check the current element
	switch(items[i])
		{
		//If any operator is found
		case "+":

		//Popping two elements
		value1 = stack.pop();
		value2 = stack.pop();
		

		//Pushing result onto stack
		stack.push(value2 + value1);

		break;

		case "-":

		//Popping two elements
		value1 = stack.pop();
		value2 = stack.pop();

		//Pushing result onto stack
		stack.push(value2 - value1);

		break;

		case "*":

		//Popping two elements
		value1 = stack.pop();
		value2 = stack.pop();

		//Pushing result onto stack
		stack.push(value2 * value1);

		break;

		case "/":

		//Popping two elements
		value1 = stack.pop();
		value2 = stack.pop();

		//Pushing result onto stack
		stack.push(value2 / value1);

		break;

		//Skipping spaces
		case " ":
		break;

		//For any operand
		default:

		//Storing all decimal numbers to stack
		stack.push(Double.parseDouble(items[i]));
		break;
	}
		}

		//Return result
		return stack.pop();
	}
}
//time complexity is O(n) n being the length of the post fix expression
//space complexity is O(n) n being the length of the post fix expression

//test cases
//to remove the last element i would create a method called remove or use Stack.remove();
//to handle invalid objects i would put the whole thing in a try catch 
//to remove objects i would use the Stack.Remove(Object) method
//to make sure the stack is not empty before a pop i would put the pop in a statement like
//if(!stack.isEmpty) stack.pop
//to avoid memory leaks i would make sure everything is popped out of the stack before exiting the code

