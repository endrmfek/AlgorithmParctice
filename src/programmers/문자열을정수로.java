package programmers;

public class 문자열을정수로 {
	public int solution(String s) {
        int answer = 0;
        if (s.charAt(0) == '-') {
        	answer = -Integer.parseInt(s.substring(1));
        } else {
        	answer = Integer.parseInt(s);
        }
        
        return answer;
    }
}
