package programmers;

public class x간격 {
	public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long temp = x;
        for(int i=0; i<n; i++) {
        	answer[i] = temp;
        	temp += x;
        }
        return answer;
    }
}
