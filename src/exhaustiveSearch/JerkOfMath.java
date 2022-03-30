package exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

public class JerkOfMath {
	public static int[] solution(int[] answers) {
		int[] number1 = {1,2,3,4,5};
		int[] number2 = {2,1,2,3,2,4,2,5};
		int[] number3 = {3,3,1,1,2,2,4,4,5,5};
		
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		
		for(int i=0; i<answers.length; i++) {
			int idx1 = i % number1.length;
			int idx2 = i % number2.length;
			int idx3 = i % number3.length;
			
			if(number1[idx1] == answers[i]) {
				result1++;
			}
			if(number2[idx2] == answers[i]) {
				result2++;
			}
			if(number3[idx3] == answers[i]) {
				result3++;
			}
		}
		int max = Math.max(Math.max(result1, result2), result3);
		
		List<Integer> answer = new ArrayList<>();
        if(max == result1) answer.add(1);
        if(max == result2) answer.add(2);
        if(max == result3) answer.add(3);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		System.out.println(solution(a));
		
	}
}
