package programmers;

import java.util.Arrays;

public class 폰켓몬 {
	public int solution(int[] nums) {
        int answer = 0;
        int min = nums.length/2;
        int[] arr = Arrays.stream(nums).distinct().toArray();
        int arrLength = arr.length;
        
        return Math.min(min,arrLength);
    }
}
