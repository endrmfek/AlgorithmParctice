package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는숫자배열 {
	public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int a : arr) {
        	if (a%divisor == 0) {
        		answer.add(a);
        	}
        }
        if(answer.size() == 0) {
        	answer.add(-1);
        }
        Collections.sort(answer);
        return answer;
    }
	
	public int[] solution2(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(i-> i%divisor == 0).sorted().toArray();
		if(answer.length == 0) {
			answer = new int[] {-1};
		}
		return answer;
	}
}
