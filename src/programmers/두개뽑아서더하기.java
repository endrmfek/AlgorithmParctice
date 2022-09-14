package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 두개뽑아서더하기 {
	public List<Integer> solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> ans = new HashSet<>();
        int n = numbers.length;
        
        for(int i=0; i<n-1; i++) {
        	for(int j=i+1; j<n; j++) {
        		int sum = numbers[i] + numbers[j];
        		ans.add(sum);
        	}
        }
        List<Integer> a = new ArrayList<>(ans);
        Collections.sort(a);
//        answer = a.stream().mapToInt(Integer::valueOf).toArray();
        return a;
    }
}
