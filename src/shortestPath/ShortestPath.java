package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPath {
	
	static class Node implements Comparable<Node> {
		
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
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
	}
	
	public static int V,E,start;
	public static int[] d;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		d = new int[V+1];
		
		for(int i=0; i<V+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		while(E-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			graph.get(u).add(new Node(v, w));
		}
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		dijkstra(start);
		
		for(int i=1; i<V+1; i++) {
			if(d[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(d[i]);
		}
	}
	
	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(s,0));
		d[s] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int nowIndex = now.getIndex();
			int nowDist = now.getDist();
			
			if(d[nowIndex] < nowDist) continue;
			
			for(int i=0; i<graph.get(nowIndex).size(); i++) {
				int nextCost = d[nowIndex] + graph.get(nowIndex).get(i).getDist();
				
				if(nextCost < d[graph.get(nowIndex).get(i).getIndex()]) {
					d[graph.get(nowIndex).get(i).getIndex()] = nextCost;
					pq.offer(new Node(graph.get(nowIndex).get(i).getIndex() , nextCost));
				}
			}
		}
	}
}
