package assignment2;

import java.util.Scanner;
import java.util.Stack;

public class Assignment2 {
	
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Enter expression: ");
	    String exp=sc.nextLine();
	    System.out.println("Evaluation= "+eval(exp));
	}
	
	public static int eval(String expression)
	{
		char[] chars = expression.toCharArray();
		
		// Stack for numbers
		Stack<Integer> values = new Stack<Integer>();

		// Stack for Operators
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < chars.length; i++)
		{
			// if current char is a whitespace, skip it
			if (chars[i] == ' ')
				continue;

			// if current char is a number, push it to stack for numbers
			if (chars[i] >= '0' && chars[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				
				// There may be more than one digit in the number
				while (i < chars.length && chars[i] >= '0' && chars[i] <= '9')
					sbuf.append(chars[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			
				// right now the i points to the character next to the digit,
				// since the for loop also increases the i, we would skip one position
				// we need to decrease the value of i by 1 to correct the offset.
				i--;
			}

			// Current token is an opening brace, push it to ops
			else if (chars[i] == '(') 
			    ops.push(chars[i]);

			// Closing brace encountered,solve entire brace
			else if (chars[i] == ')')
			{
				while (ops.peek() != '(')
				values.push(applyOp(ops.pop(),values.pop(),values.pop()));
				ops.pop();
			}

			// if current token is an operator.
			else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' ||
						chars[i] == '/')
			{
				
				while (!ops.empty() && hasPrecedence(chars[i],ops.peek()))
				values.push(applyOp(ops.pop(),values.pop(),	values.pop()));

				ops.push(chars[i]);  // Push current token to 'ops'.
			}
		}

		// Entire expression has been parsed at this point, apply remaining ops to remaining values
		while (!ops.empty())
			values.push(applyOp(ops.pop(),values.pop(),values.pop()));

		return values.pop();  // Top of 'values' contains result, return it
	}

	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}
	// A method to apply an operator on 'a' and 'b'. Return the result.
	public static int applyOp(char op,int b, int a) {
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}
	
}

//test cases
//to remove the last element i would create a method called remove or use Stack.remove();
//to handle invalid objects i would put the whole thing in a try catch 
//to remove objects i would use the Stack.Remove(Object) method
//to make sure the stack is not empty before a pop i would put the pop in a statement like
//if(!stack.isEmpty) stack.pop
//to avoid memory leaks i would make sure everything is popped out of the stack before exiting the code



