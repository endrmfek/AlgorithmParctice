package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1033 {
	static class Node {
		int b;
		int p;
		int q;
		
		Node(int b, int p, int q) {
			this.b = b;
			this.p = p;
			this.q = q;
		}
		
	}
	static long lcm;
	static long[] result;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		
		lcm = 1;
		
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, p, q));
			graph.get(b).add(new Node(a, q, p));
			
			lcm *= ((p*q) / gcd(p,q)); //최소 공배수를 구해놓고.
//			System.out.println(lcm);
		}
		
		result = new long[n];
		
		result[0] = lcm;
//		System.out.println(lcm);
		DFS(0);
		long mgcd = result[0];
		for(int i=1; i<n; i++) {
			mgcd = gcd(mgcd, result[i]);
		}
		
		for(int i=0; i<n; i++) {
			System.out.print( result[i] / mgcd + " ");
//			System.out.print( result[i] + " ");
		}
	}
	
	private static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
		
	}
	
	private static void DFS(int start) {
		visited[start] = true;
		
		for(Node n : graph.get(start)) {
			int next = n.b;
			if(!visited[next]) {
				result[next] = result[start] * n.q / n.p;
				DFS(next);
			}
		}
		
		
	}
}
