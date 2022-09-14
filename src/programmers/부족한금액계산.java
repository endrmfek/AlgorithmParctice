package programmers;

public class 부족한금액계산 {
	public long solution(int price, int money, int count) {
        long answer = 0;
        long total = 0;
        for(int i=1; i<=count; i++) {
        	total += (price * i);
        }
        
        if (total < money) {
        	answer = 0;
        } else {
        	answer = total- money;
        }
        return answer;
    }
}
