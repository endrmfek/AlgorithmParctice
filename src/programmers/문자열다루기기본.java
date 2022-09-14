package programmers;

public class 문자열다루기기본 {
	public boolean solution(String s) {
        boolean answer = false;
        if (s.length() == 4 || s.length() == 6) {
        	answer = true;
        }
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++) {
        	if (Character.isLetter(arr[i])) {
        		answer = false;
        		break;
        	}
        }
        return answer;
    }
}
