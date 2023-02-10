package sorting;

import java.util.Arrays;

public class H_Index {
	//n편 중 h번 이상 인용된
	//논문이 h편 이상
	//나머지 논문이 h번 이하
	public int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		
		for(int i=0; i<citations.length; i++) {
			//{0,1,3,5,6}
			//citations[i]번 이상 인용된 논문 개수 = h
			int h = citations.length - i;

			//h의 최대값
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
