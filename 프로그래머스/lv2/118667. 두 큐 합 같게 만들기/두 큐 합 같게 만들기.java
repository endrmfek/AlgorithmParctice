import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
//        람다 쓰지마 존나 느려.
//        Queue<Integer> q1 = new LinkedList<>(Arrays.stream(queue1).boxed().collect(Collectors.toList()));
//        Queue<Integer> q2 = new LinkedList<>(Arrays.stream(queue2).boxed().collect(Collectors.toList()));
//        
//        int sum1 = q1.stream().mapToInt(Integer::intValue).sum();
//        int sum2 = q2.stream().mapToInt(Integer::intValue).sum();
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0; i<queue1.length; i++) {
        	q1.add(queue1[i]);
        	q2.add(queue2[i]);
        	sum1 += queue1[i];
        	sum2 += queue2[i];
        }

        long sum = (sum1 + sum2) / 2;
        
        if((sum1 + sum2)%2 != 0 ) { 
        	return -1;
        }
        
        int cnt = 0;
        while(cnt < queue1.length * 3) {
        	if (sum1 > sum) {
        		int front = q1.poll();
        		q2.add(front);
        		sum1 -= front;
        		sum2 += front;
        		cnt += 1;
        	}
        	else if (sum2 > sum) {
        		int front = q2.poll();
        		q1.add(front);
        		sum1 += front;
        		sum2 -= front;
        		cnt += 1;
        	}
        	
        	if(sum1 == sum2) {
        		return cnt;
        	}
        	
        }
        return -1;
    }
}