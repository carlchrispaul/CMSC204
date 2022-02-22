package Project2;

/**
 * Notation Class
 * @author CCPaulHipolito
 */

public class Notation {
	
	/**
	 * Constructor
	 */
	public Notation() {}
	
	/**
	 * Convert Infix to Postfix
	 * @param infix to be converted to postfix
	 * @return String Postfix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		NotationStack<String> stack = new NotationStack<>();
		NotationQueue<String> queue = new NotationQueue<>();
		String result = "";
		
		try {
			for(int i = 0; i < infix.length(); i++) {
				char c = infix.charAt(i);
				
				if(Character.isLetterOrDigit(c)) {
					queue.enqueue(Character.toString(c));
				} else if (c == '(') {
					stack.push(Character.toString(c));
				} else if (c == ')' ) {
					String peekStack = stack.top();
					while(!stack.isEmpty() && peekStack != ("(")) {
						queue.enqueue(stack.pop());
						stack.pop();
					}
				} else {
					boolean checker = isOperation(c);
					while(!stack.isEmpty() && !checker) {
						if (pemdas(c) < 2) {
							if(pemdas(c) == 2)
								queue.enqueue(stack.pop());
							else
								checker = true;
						} else
							checker = true;
					}
					stack.push(Character.toString(c));
				}
			}
			
			while(!stack.isEmpty()) {
				queue.enqueue(stack.pop());
			}
			
			while(!queue.isEmpty()) {
				result += queue.dequeue();
			}
			
		} 
		catch (StackUnderflowException e) { throw new InvalidNotationFormatException(); }
		catch (StackOverflowException e) { System.out.println(e.getMessage()); }
		catch (QueueOverflowException e) { System.out.println(e.getMessage()); }
		catch (QueueUnderflowException e) { System.out.println(e.getMessage()); }
		
		return result;
	}
	
	/**
	 * Convert Postfix to Infix
	 * @param postfix to be converted to infix
	 * @return String Infix Expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		NotationStack<String> stack = new NotationStack<>();
		String result = "";
		
		try {
			for(int i = 0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				boolean checker = isOperation(c);
				
				if(Character.isLetterOrDigit(c)) {
					stack.push(Character.toString(c));
				} else if(checker){
					String num2 = stack.pop();
					String num1 = stack.pop();
					stack.push(num1 + c + num2);
				} else {
					stack.push(Character.toString(c));
				}
			}
			result = stack.pop();
			if(!stack.isEmpty())
				throw new InvalidNotationFormatException();
			else
				return result;
		} 
		catch (StackUnderflowException e) { throw new InvalidNotationFormatException(); }
		catch (StackOverflowException e) { System.out.println(e.getMessage()); }
		
		return result;
	}
	
	/**
	 * Evaluate Postfix expression
	 * @param postfixExpr to be evaluated
	 * @return double value of the Postfix expression
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		NotationStack<Double> stack = new NotationStack<Double>();
		
		try {
			for(int i = 0; i < postfixExpr.length(); i++) {
				char c = postfixExpr.charAt(i);
				if(Character.isDigit(c))
					stack.push((double)c - '0');
				else {
					if(stack.size() < 2)
						throw new InvalidNotationFormatException();
					else {
						Double num1 = stack.pop();
						switch (c) {
						case '+':
							stack.push(num1 + stack.pop());
							break;
						case '-':
							stack.push(num1 - stack.pop());
							break;
						case '*':
							stack.push(num1 * stack.pop());
							break;
						case '/':
							stack.push(num1 / stack.pop());
							break;
						}
					}
				}
			}	
			return Math.round(stack.pop());
		}
		catch (StackUnderflowException e) { throw new InvalidNotationFormatException(); }
		catch (StackOverflowException e) { System.out.println(e.getMessage()); }
		return 0;
	}
	
	/**
	 * Private method to sort the order of operation
	 * @param op character operator
	 * @return 1 for addition and/or subtraction, 2 for multiplication and/or division
	 */
	private static int pemdas(char op) {
		switch(op) {
		case '+': case '-':
			return 1;
		case '*': case '/':
			return 2;
		}
		return -1;
	}
	
	/**
	 * Private method to distinguish operators
	 * @param op character operator
	 * @return true if an operator, false otherwise
	 */
	private static boolean isOperation(char op) {
		switch(op) {
		case '+': case '-': case '*': case '/':
			return true;
		default:
			return false;
		}
	}
}