package programmers;

public class 두정수사이의합 {
	public long solution(int a, int b) {
        long answer = 0;
        int a1 = Math.min(a,b);
        int b2 = Math.max(a,b);
        for(int i=a1; i<=b2; i++) {
        	answer += i;
        }
        return answer;
    }
}
