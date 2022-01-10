package gridy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//아주 간단하게 풀수 있다고 생각했지만 실패.
//객체를 만들어야되는 문제도 있구나.. 를 발견

class Food implements Comparable<Food>{
	private int index;
	private int time;
	
	public Food(int index, int time) {
		this.index = index;
		this.time = time;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getTime() {
		return time;
	}
	@Override
	public int compareTo(Food other) {
		// TODO Auto-generated method stub
		return this.time - other.time; // 시간에 따라 오름차순
	}
}

public class MujiSolution {

	public int Solution(int[] food_times, long k) {
		//더 섭취해야될 음식이 없다면 -1.
		int summary = 0;
		for(int i=0; i<food_times.length; i++) {
			summary += food_times[i];
		}
		if(summary > k) return -1;
		
		PriorityQueue<Food> pq = new PriorityQueue<>(); // 적은 음식순으로
		for(int i=0; i<food_times.length; i++) {
			pq.offer(new Food(food_times[i], i+1)); //(음식 시간, 번호) 형태로 큐에 삽입
		}
		
		summary =0;
		long previous = 0; //직전에 다 먹은 음식 시간
		long length = food_times.length; // 음식의 개수
		
		//summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k비교
		while(summary + ((pq.peek().getTime() - previous) * length) <= k) {
			int now = pq.poll().getTime();
			summary += (now - previous) *length;
			length -= 1;
			previous = now;
		}
		
		//남은 음식 중 몇번째 음식인지
		ArrayList<Food> result = new ArrayList<>();
		while(!pq.isEmpty()) {
			result.add(pq.poll());
		}
		
		//음식의 번호 기준으로 (원래대로)
		Collections.sort(result, new Comparator<Food>() {
			public int compare(Food o1, Food o2) {
				return o1.getIndex() - o2.getIndex();
			};
		});
		
		return result.get((int) ((k-summary)%length)).getIndex();
	}
	
	public static void main(String[] args) {
		
	}

}
