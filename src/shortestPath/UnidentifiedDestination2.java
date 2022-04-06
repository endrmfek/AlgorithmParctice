package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UnidentifiedDestination2 {
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
		
		public void setDist(int dist) {
			this.dist = dist;
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
				
				graph.get(a).add(new Node(b, c*2)); //가중치 2배를해서 짝수로 만듬.
				graph.get(b).add(new Node(a, c*2));
			}
			
			for(int i=0; i<graph.get(g).size(); i++) { //ㅅㅂ 노드 값바꾸는게 개노답이다진짜
				if(graph.get(g).get(i).getIndex() == h) {
					graph.get(g).get(i).setDist(graph.get(g).get(i).getDist() - 1);
				}
			}
			
			for(int i=0; i<graph.get(h).size(); i++) {
				if(graph.get(h).get(i).getIndex() == g) {
					graph.get(h).get(i).setDist(graph.get(h).get(i).getDist() - 1);
				}
			}
			
			int[] candidate = new int[T];
			for(int i=0; i<T; i++) {
				candidate[i] = sc.nextInt();
			}
			
			Arrays.sort(candidate);
			
			dijkstra(s);
			
			for(int c : candidate) { //짝수 + 홀수 -> 홀수라는점을 이용해 해당 경로를 지났는지 검사
				if(d[c] % 2 !=0 ) {
					System.out.print(c + " ");
				}
			}
			System.out.println();
			
		}
	}
	
	
	public static void dijkstra(int start) {
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
		
		
	}
}
