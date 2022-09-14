package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승택시요금 {
	static ArrayList<ArrayList<node_1>> graph;
	static final int INF = 20000001;
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        //n -> 노드 , s ->시작점 ,a-> 도착점, b-> 도착점. [a , b, c] a -> b,c
        int answer = INF;
        graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
        	graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares) {
        	int A = fare[0];
        	int B = fare[1];
        	int C = fare[2];
        	graph.get(A).add(new node_1(B,C));
        	graph.get(B).add(new node_1(A,C));
        }
        
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start = new int[n+1];
        
        Arrays.fill(start, INF);
        Arrays.fill(startA, INF);
        Arrays.fill(startB, INF);
        
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);
        
        for(int i=1; i<=n; i++) {
        	answer = Math.min(answer, start[i] + startA[i] + startB[i]);
        }
        
        return answer;
    }
	
	static int[] dijkstra(int start, int[] costs) {
		PriorityQueue<node_1> pq = new PriorityQueue<>(Comparator.comparing(node_1::getDist));
		
		
		pq.offer(new node_1(start, 0));
		costs[start] = 0;
		
		while(!pq.isEmpty()) {
			node_1 now = pq.poll();
			int nowNode = now.next;
			int nowDist = now.dist;
			
			if(costs[nowNode] < nowDist) {
				continue;
			}
			
			for(node_1 next : graph.get(nowNode)) {
				int cost = costs[nowNode] + next.dist;
				
				if(cost < costs[next.next]) {
					costs[next.next] = cost;
					pq.offer(new node_1(next.next, cost));
				}
			}
			
		}
		
		return costs;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(6,4,6,2, new int[][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
	}
}

class node_1 {
	int next;
	int dist;
	
	node_1(int next, int dist) {
		this.next = next;
		this.dist = dist;
	}
	
	int getDist() {
		return dist;
	}
}
