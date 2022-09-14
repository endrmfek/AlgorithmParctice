package programmers;

public class 정수제곱근 {
	public long solution(long n) {
        long answer = 0;
        double a = Math.sqrt(n);
        
        if (a%1 != 0) {
        	answer = -1;
        } else {
        	answer = (long) Math.pow(a+1, 2);
        }
        
        return answer;
    }
}
