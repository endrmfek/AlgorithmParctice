package programmers;

public class 소수찾기 {
	public int solution(int n) {
        int answer = 1;
        for(int i=2; i<=n; i++) {
        	if (check(i)) {
        		answer +=1;
        	}
        }
        
        return answer;
    }
	public boolean check(int num) {
		boolean ch = true;
		for(int i=2; i<Math.sqrt(num) + 1; i++) {
			if (num % i == 0) {
				ch = false;
				break;
			}
		}
		return ch;
	}
	
	public int find(int num) {
		int answer = 0;
		int[] number = new int[num+1];
		
		for(int i=2; i<=num; i++) {
			number[i] = i;
		}
		
		for(int i=2; i*i<=num; i++) {
			if(number[i] == 0) continue;
			
			for(int j = i*i; j<=num; j+=i) {
				number[j] = 0;
			}
		}
		
		for(int i=0; i<number.length; i++) {
			if(number[i] !=0) {
				answer++;
			}
		}
		return answer;
	}
}
