package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 제일작은수제거 {
	public List<Integer> solution(int[] arr) {
        int[] answer = {};
        List<Integer> a = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if (arr.length == 1) {
        	List<Integer> result = new ArrayList<>();
        	result.add(-1);
        	return result;
        } else {
        	int min_value = Integer.MAX_VALUE;
        	int min_index = 0;
        	for(int i=0; i<arr.length; i++) {
        		if (arr[i] < min_value) {
        			min_index = i;
        			min_value = arr[i];
        		}
        	}
        	a.remove(min_index);	
        }
        
        return a;
    }
}
