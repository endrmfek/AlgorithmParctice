package gridy;

import java.util.Stack;

public class LargestNumber {
	
	
	public String solution(String number, int k) {
		
		int size = number.length() -k;
		
		char[] input = number.toCharArray();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length; i++) {
			//4177252841
			while(!stack.empty() && k>0 && stack.peek() < input[i]) {
				k--;
				stack.pop();
			}
			
			stack.push(input[i]);
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			sb.append(stack.get(i));
		}
		
        return sb.toString();
    }

	public static void main(String[] args) {
		LargestNumber a = new LargestNumber();
		System.out.println(a.solution("4177252841", 3));
	}
	
}
