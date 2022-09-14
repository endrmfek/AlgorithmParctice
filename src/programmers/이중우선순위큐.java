package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	public static int[] solution(String[] operations) {
        int[] answer = {};
        
        //원래 최소힙.
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(String op : operations) {
        	String[] value = op.split(" ");
        	
        	if (value[0].equals("I")) {
        		minQ.add(Integer.parseInt(value[1]));
        		maxQ.add(Integer.parseInt(value[1]));
        	} else { // D일때
        		if(minQ.isEmpty()) {
        			continue;
        		}
        		if(value[1].equals("1")) { // 최대값
        			int maxValue = maxQ.poll();
        			minQ.remove(maxValue);
        		} else {
        			int minValue = minQ.poll();
        			maxQ.remove(minValue);
        		}
        	}
        }
        
        if (minQ.size() >= 2) {
        	return new int[] {maxQ.poll(), minQ.poll()};
        } else {
        	return new int[] {0,0};
        }
        
    }
	
	public static void main(String[] args) {
		solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
	}
}
