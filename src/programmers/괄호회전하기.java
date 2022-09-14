package programmers;

import java.util.Stack;

public class 괄호회전하기 {
	public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for(int i=0; i<len; i++) {
        	//왼쪽으로 i만큼 옮겨
        	char[] temp = move(s, i);
        	//맞는괄호인지 체크해.
        	if(check(temp)) {
        		answer++;
        	}
        }
        
        	
        return answer;
    }
	
	char[] move(String s, int idx) {
		char[] temp = s.toCharArray();
		char[] newChar = new char[s.length()];
		
		for(int i=0; i<s.length(); i++) {
			int next = i-idx;
			if (next < 0) {
				next = next + s.length();
			}
			newChar[i] = temp[next];
		}
		
		return newChar;
	}
	
	boolean check(char[] newChar) {
		//괄호쌍 어떻게 검사할꺼야?
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<newChar.length; i++) {
			if(newChar[i] == '{' || newChar[i] == '(' || newChar[i] =='[') {
				stack.add(newChar[i]);
			}
			
			if(newChar[i] == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				
				if(stack.peek() == '{') {
					stack.pop();
				}
			}
			
			if(newChar[i] ==']') {
				if (stack.isEmpty()) {
					return false;
				}
				if(stack.peek() == '[') {
					stack.pop();
				}
			}
			
			if(newChar[i]==')') {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek() == '(') {
					stack.pop();
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
