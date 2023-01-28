package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을둘로나누기 {
	List<Integer>[] list;
	public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new List[n+1];
        for(int i=0; i<=n; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
        	list[wire[0]].add(wire[1]); // 양방향그래프로 만들고
        	list[wire[1]].add(wire[0]);
        }
        
        for(int[] wire : wires) {
        	int a = bfs(wire[0], wire[1] , n);	//-> wire[0] 부터 탐색 시작 , wire[1] 만나면 탐색 종료.
//        	int b = bfs(wire[1], wire[0] , n);
			int b = n-a;
        	answer = Math.min(answer, Math.abs(a-b));
        }
        
        return answer;
    }
	
	public int bfs(int v1, int v2, int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		int count =0;
		q.offer(v1);
		visited[v1] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			count+=1;
			
			for(int next : list[now]) {
				if(next != v2 && !visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		return count;
	}
}
