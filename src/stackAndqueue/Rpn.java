package stackAndqueue;

import java.util.Deque;
import java.util.LinkedList;

public class Rpn {

	public static int eval(String RPNExpression) {
		Deque<Integer> intermediateResults = new LinkedList<>();
		String delimiter = ",";
		String[] symbols = RPNExpression.split(delimiter);
		for(String token : symbols) {
			if(token.length() == 1 && "+-*/".contains(token)) {
				final int x = intermediateResults.removeFirst();
				final int y = intermediateResults.removeFirst();
				
				switch (token.charAt(0)) {
				case '+':
					intermediateResults.addFirst(x+y);
					break;

				case '-':
					intermediateResults.addFirst(x-y);
					break;

				case '*':
					intermediateResults.addFirst(x*y);
					break;

				case '/':
					intermediateResults.addFirst(x/y);
					break;

				default:
					throw new IllegalStateException("Malformed RPN at :" + token);
					
				} 
			} else {
				intermediateResults.addFirst(Integer.parseInt(token));
			}
		}
		return intermediateResults.removeFirst();
	}
}
