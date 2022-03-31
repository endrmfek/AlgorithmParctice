package gridy;

import java.math.MathContext;

public class Joystick {
	
	public int solution(String name) {
		return countUpDown(name) + countLeftRight(name);
    }
	
	private int countUpDown(String name) {
		int count = 0;
		for(char ch : name.toCharArray()) {
			count += Math.min(ch-'A' , 'Z'-ch+1);
		}
		return count;
	}
	
	private int countLeftRight(String name) {
		int min = name.length() -1;
		for(int i=0; i<name.length(); i++) {
			int endOfIndex = i;
			if(name.charAt(endOfIndex) == 'A') {
				while(endOfIndex < name.length() && name.charAt(endOfIndex) == 'A') endOfIndex++;
				int move = ((i-1) * 2) + (name.length() - endOfIndex);
				min = Math.min(min, Math.max(0, move));
			}
		}
		return min;
	}
	
	
}
