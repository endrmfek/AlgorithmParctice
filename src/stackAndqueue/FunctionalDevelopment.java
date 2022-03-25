package stackAndqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionalDevelopment {

	
	public int[] solution(int[] progresses, int[] speeds) {
		//[진척도] , [speed]
		//뒤에꺼가 먼저 완료되도 앞에 일이 안끝나면 처리를 못함.
		// 큐를 사용해야 될거 같음.
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<progresses.length; i++) {
			int complete =(int) (Math.ceil((100.0 - progresses[i]) / speeds[i]));
			q.offer(complete);
		}
		
		
		List<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			
			int day = q.poll();
			int count = 1;
			
			while(!q.isEmpty() && day >= q.peek()) {
				count++;
				q.poll();
			}
			
			result.add(count);
		}
		
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
