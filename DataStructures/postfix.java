package finalexam;

import java.util.Stack;

public class postfix {

	public static void main(String[] args) {
		String expression = "2 1 + 4 *";

		System.out.println(expression + " = " + PostFixEval(expression));
		
		
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


