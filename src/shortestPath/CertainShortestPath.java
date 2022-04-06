package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CertainShortestPath {

	static class Node implements Comparable<Node>{
		private int index;
		private int dist;
		
		Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}
		
		public int getIndex() {
			return index;
		}
		
		public int getDist() {
			return dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	public static int V, E, START, mustV1, mustV2;
	public static int[] d;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static int[] visited;
	public static final int INF = 200000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		d = new int[V+1];
		visited = new int[V+1];
		Arrays.fill(d, INF);
		
		for(int i=0; i<V+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int	b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));
		}
		
		mustV1 = sc.nextInt();
		mustV2 = sc.nextInt();
		
		// 1-> v1 -> v2-> N
		int result1 = 0;
		result1 += dijkstra(1,mustV1);
		result1 += dijkstra(mustV1,mustV2);
		result1 += dijkstra(mustV2,V);
		
		int result2 = 0;
		result2 += dijkstra(1, mustV2);
		result2 += dijkstra(mustV2, mustV1);
		result2 += dijkstra(mustV1, V);
		
		int result = Math.min(result1, result2) >= INF ? -1 : Math.min(result1, result2);
		System.out.println(result);
		
	}
	
	public static int dijkstra(int start, int end) {
		Arrays.fill(d, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int nowIndex = n.getIndex();
			int nowDist = n.getDist();
			
			if(d[nowIndex] < nowDist) continue;
			
			for(int i=0; i<graph.get(nowIndex).size(); i++) {
				int nextCost = d[nowIndex] + graph.get(nowIndex).get(i).getDist();
				
				if(nextCost < d[graph.get(nowIndex).get(i).getIndex()]) {
					d[graph.get(nowIndex).get(i).getIndex()] = nextCost;
					pq.offer(new Node(graph.get(nowIndex).get(i).getIndex(), nextCost));
				}
			}
		}
		
		return d[end] >= INF ? INF : d[end];
	}
}
