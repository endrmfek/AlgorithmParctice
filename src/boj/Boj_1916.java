package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_1916 { // 다익스트라.
	
	static class Node implements Comparable<Node>{
		int index;
		int dist;
		
		Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
		// TODO Auto-generated method stub
			return this.dist-o.dist;
		}
		
	}
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] distance;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 도시개수
		int m = sc.nextInt(); // 버스 개수
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(a).add(new Node(b, c));
		}
		
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		distance[start] = 0;
		dijkstra(start);
		
		System.out.println(distance[end]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int index = now.index;
			int	dist = now.dist;
			
			if(distance[index] < dist) continue;
			
			for(Node next : graph.get(index)) {
				int nextIndex = next.index;
				int nextCost = distance[index] + next.dist;
				
				if(distance[nextIndex] > nextCost) {
					distance[nextIndex] = nextCost;
					q.offer(new Node(nextIndex, nextCost));
 				}
			}
		}
	}

}
