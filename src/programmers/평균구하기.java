package programmers;

import java.util.Arrays;

public class 평균구하기 {
	public double solution(int[] arr) {
        double answer = Arrays.stream(arr).mapToDouble(i->i).sum();
        answer = answer/arr.length;
        
        return answer;
    }
}
