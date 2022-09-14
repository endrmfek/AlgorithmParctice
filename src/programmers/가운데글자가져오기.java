package programmers;

public class 가운데글자가져오기 {
	public String solution(String s) {
        String answer = "";
        if(s.length() % 2 == 1) { // 홀수면
        	answer += s.charAt(s.length()/2);
        } else {
        	answer += s.charAt(s.length()/2-1);
        	answer += s.charAt((s.length()/2));
        }
        return answer;
    }
}
