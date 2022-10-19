package programmers;

import java.util.HashMap;
import java.util.Map;

public class NumberTwo {
	public int[] solution(int[][] orders) {
        int[] answer = {};
        int N = orders.length;
        int banNumber = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        if(orders.length %2 == 0) {
        	banNumber = orders.length / 2;
        } else {
        	banNumber = (orders.length + 1) / 2;
        }
        
        while (true) {
        	count += 1;
        	int max_score = -1;
        	int min_score = 10001;
        	for(int i=0; i<orders.length; i++) {
        		map.put(orders[i][0], map.getOrDefault(orders[i][0], 1) + 1);
            }
        	
        	for(Integer key : map.keySet()) {
        		int score = map.get(key);
        		max_score = Math.max(max_score , score);
        		min_score = Math.min(min_score, score);
        	}
        	
        	
        }
    }
}
