package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1414 {
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int value;
		
		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		
		@Override
		public int compareTo(Edge o) {
			return value - o.value;
		}
		
	}
	static int[] parent;
	static int n, sum;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			char[] tempc = st.nextToken().toCharArray();
			for(int j=0; j<n; j++) {
				int temp = 0;
				if(tempc[j] >= 'a' && tempc[j] <= 'z') {
					temp = tempc[j] - 'a' + 1;
				} else if (tempc[j] >= 'A' && tempc[j] <='Z') {
					temp = tempc[j] -'A' + 27;
				}
				sum = sum + temp; // 랜선 총 합
				if(i != j && temp !=0) pq.offer(new Edge(i, j, temp));
			}
		}
		
		parent = new int[n];
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		int useEdge = 0;
		int result = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(find(now.start) != find(now.end)) {
				union(now.start, now.end);
				result = result + now.value;
				useEdge++;
			}
		}
		
		if(useEdge == n-1 ) System.out.println(sum - result);
		else System.out.println("-1");
		
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	
	public static int find(int a) {
		if(a == parent[a]) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}
	
}
