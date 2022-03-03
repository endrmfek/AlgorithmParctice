package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node_h implements Comparable<Node_h>{
	private int index;
	private int distance;
	
	public Node_h(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	@Override
	public int compareTo(Node_h other) {
		// TODO Auto-generated method stub
		return this.index - other.index;
	}
}


public class HideAndSeek {
	public static final int INF = (int)1e9;
	public static int n, m ;
	public static int start = 1;
	public static ArrayList<ArrayList<Node_h>> graph = new ArrayList<>(); //n이 너무크면 어레이리스트로 가야돼.
	public static int[] d = new int[20001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node_h> pq = new PriorityQueue<>();
		pq.offer(new Node_h(start , 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node_h node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			if(d[now] < dist) continue;
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = dist + graph.get(now).get(i).getDistance();
				
				if( cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node_h(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node_h>());
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(new Node_h(b,1)); //양방향
			graph.get(b).add(new Node_h(a, 1));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		//최단거리가 먼 노드
		int maxNode = 0;
		//갈수 있는 노드 중 가장 먼 노드와의 최단 거리?..
		int maxDistnace = 0;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<=n; i++) {
			if(maxDistnace < d[i]) {
				maxNode = i;
				maxDistnace = d[i];
				result.clear();
				result.add(maxDistnace);
			}
			
			else if(maxDistnace == d[i]) {
				result.add(i);
			}
		}
		
		System.out.println(maxNode + " " + maxDistnace + " " + result.size());
	}
	
}
