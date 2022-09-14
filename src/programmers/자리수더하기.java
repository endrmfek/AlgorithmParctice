package programmers;

public class 자리수더하기 {
	public int solution(int n) {
        int answer = 0;
        while (n != 0) {
        	int remainder = n%10;
        	n = n/10;
        	answer += remainder;
        }
        return answer;
    }
}
