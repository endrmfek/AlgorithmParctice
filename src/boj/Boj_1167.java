package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1167 { //왜 안됨요??..
	
	static class Node{
		int index;
		int dist;
		
		public Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}
	}
	
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] result;
	static boolean[] visited;
	static int n;
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<n; i++) { //그래프 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); 
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				if(e == -1) {
					break;
				}
				int val = Integer.parseInt(st.nextToken());
				graph.get(v).add(new Node(e, val));
			}
		}
		
		result = new int[n+1];
		visited = new boolean[n+1];
		bfs(1);
		
		int max = 1;
		for(int i=2; i<=n; i++) {
			if(result[max] < result[i]);
				max = i;
		}
		
		result = new int[n+1];
		visited = new boolean[n+1];
		bfs(max);
		Arrays.sort(result);
		System.out.println(result[n]);
 	}
	
	
	static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(Node n : graph.get(now)) {
				int next = n.index;
				int value = n.dist;
				
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
					result[next] = result[now] + value;
				}
			}
		}
	
	}
}
