package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UnidentifiedDestination {
	static class Node implements Comparable<Node> {
		private int index;
		private int dist;
		
		public Node(int index, int dist) {
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
	
	public static int N,M,T;
	public static ArrayList<ArrayList<Node>> graph ;
	public static int[] d;
	public static final int INF = 50000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		while(tc-- > 0) {
			
			graph = new ArrayList<>();
			N = sc.nextInt(); // 노드
			M = sc.nextInt(); // 간선
			T = sc.nextInt(); // 후보지
			
			
			for(int i=0; i<N+1; i++) {
				graph.add(new ArrayList<>());
			}
			int s = sc.nextInt(); // 출발지
			int g = sc.nextInt(); //
			int h = sc.nextInt(); // g와 h를 거쳐
			
			while(M-- > 0 ) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				
				graph.get(a).add(new Node(b, c)); 
				graph.get(b).add(new Node(a, c));
			}
			
			int[] candidate = new int[T];
			for(int i=0; i<T; i++) {
				candidate[i] = sc.nextInt();
			}
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int c : candidate) {
				int res1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, c);
				int res2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, c);
				int res3 = dijkstra(s, c);
				
				if(Math.min(res1, res2) == res3) {
					pq.add(c);
				}
			}
			
			while(!pq.isEmpty()) {
				System.out.print(pq.poll() + " ");
			}
			System.out.println();
			
			
		}
	}
	
	
	public static int dijkstra(int start, int end) {
		d = new int[N+1];
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
				
				if(d[graph.get(nowIndex).get(i).getIndex()] > nextCost) {
					d[graph.get(nowIndex).get(i).getIndex()] = nextCost;
					pq.offer(new Node(graph.get(nowIndex).get(i).getIndex() , nextCost));
				}
			}
		}
		
		return d[end];
	}
}
