package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
	//단순하게 가자 단순하게.
	//각 큐의 합에서 중간값보다 큰 큐에서 작은큐로 옮겨보자.
	//종료 조건 : 홀수 or 처음 큐의 크기 * 2 이상 (한쪽에서 반대쪽으로 다옮기고 반대쪽에서 한쪽으로 다옮기는 경우)
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
        
        long sumQ1 = 0;
        long sumQ2 = 0;
        
        for(int i=0; i<queue1.length; i++) {
        	q1.add(queue1[i]);
        	q2.add(queue2[i]);
        	sumQ1 += queue1[i];
        	sumQ2 += queue2[i];
        }

        long totalSum = (sumQ1 + sumQ2) / 2;
        
        if((sumQ1 + sumQ2)%2 != 0 ) { 
        	return -1;
        }
        
        int cnt = 0;
        while(cnt < queue1.length * 3) {
        	if (sumQ1 > totalSum) {
        		int front = q1.poll();
        		q2.add(front);
        		sumQ1 -= front;
        		sumQ2 += front;
        		cnt += 1;
        	}
        	else if (sumQ2 > totalSum) {
        		int front = q2.poll();
        		q1.add(front);
        		sumQ1 += front;
        		sumQ2 -= front;
        		cnt += 1;
        	}
        	
        	if(sumQ1 == sumQ2) {
        		return cnt;
        	}
        	
        }
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,2,7,2}, new int[] {4,6,5,1}));
	}
}
