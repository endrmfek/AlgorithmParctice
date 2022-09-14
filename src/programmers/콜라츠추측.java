package programmers;

public class 콜라츠추측 {
	public int solution(long num) {
        int answer = 0;
        
        //2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
        while(num != 1) {
        	//1-1. 입력된 수가 짝수라면 2로 나눕니다. 
            if(num%2 == 0) {
            	num = num/2;
            	answer += 1;
            } else {
            	num = num*3 +1;
            	answer +=1;
            }
            //1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
        }
        if( answer <500) {
        	return answer;
        } else {
        	return -1;
        }
        
    }
	
	
}
