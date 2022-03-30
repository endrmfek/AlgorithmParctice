package sorting;

import java.util.Arrays;

public class H_Index {
	
	public int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		
		for(int i=0; i<citations.length; i++) {
			//{0,1,3,5,6}
			int h = citations.length - i; //논문 개수
			
			if(citations[i] >= h) {
				answer = h;
				break;
			}
		}
        return answer;
    }
	
	public int solution2(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		for(int i=0; i<citations.length; i++) {
			int smaller = Math.min(citations[i], citations.length-i);
			answer = Math.max(answer, smaller);
		}
		return answer;
	}
	
}
