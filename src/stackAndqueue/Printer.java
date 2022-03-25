package stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
	
	static class Node{
		private int value;
		private int index;
		
		public Node(int value , int index) {
			this.value = value;
			this.index = index;
		}
	}
	
	public static int solution(int[] priorities, int location) {
		//무지성 풀이
		Queue<Node> q = new LinkedList<>();
		int answer =0;
		
		for(int i=0; i<priorities.length; i++) { //세팅 끝내고
			q.offer(new Node(priorities[i], i));
		}
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			boolean flag = false;
			for(Node i : q) {
				if(i.value > now.value) { // 큐안에 더 큰 우선순위 있으면
					flag = true;
				}
			}
			
			if(flag) {
				q.offer(now);
			} else { //우선순위가 제일 크다?
				answer++;
				if(now.index == location) {
					return answer;
				}
			}
		}
		   
        return 0;
    }
	
	public static void main(String[] args) {
		int[] a = {2,1,3,2};
		System.out.println(solution(a, 2));
	}

}
