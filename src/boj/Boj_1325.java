package boj;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1325 {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean visited[];
	static int[] result;
	static int v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		int e = sc.nextInt();
		
		for(int i=0; i<v+1; i++) {
			graph.add(new ArrayList<>());
		}
		result = new int[v+1];
		
		for(int i=0; i<e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		for(int i=1; i<=v; i++) {
			bfs(i);
		}
		
		int maxV = 0;
		for(int i=1; i<=v; i++) {
			maxV = Math.max(maxV , result[i]);
		}
		
		for(int i=1; i<=v; i++) {
			if(result[i] == maxV) {
				System.out.print(i + " ");
			}
		}
		
	}
	
	private static void bfs(int s) { 
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		
		visited = new boolean[v+1];
		visited[s] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(Integer next : graph.get(now)) {
				
				if(!visited[next]) {
					visited[next] = true;
					result[next] += 1;
					q.offer(next);
				}
			}
		}
	}
}
