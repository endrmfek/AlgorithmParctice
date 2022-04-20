package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1197 {
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int value;
		
		Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return value - o.value;
		}
		
	}
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		parent = new int[v+1];
		
		for(int i=0;i<v+1; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			q.add(new Edge(a,b,c));
		}
		
		int useEdge =0;
		int result =0;
		
		while(useEdge < v-1) { // 최소신장 트리 엣지 개수 = v-1
			Edge now = q.poll();
			if(find(now.start) != find(now.end)) {
				union(now.start , now.end);
				result = result + now.value;
				useEdge++;
			}
		}
		System.out.println(result);
	}
	
	public static void union(int start, int end) {
		int x = find(start);
		int y = find(end);
		
		if(x != y) {
			parent[y] = x;
		}
	}
	
	public static int find(int number) {
		if(number == parent[number]) {
			return number;
		} else {
			return parent[number] = find(parent[number]);
		}
	}
}