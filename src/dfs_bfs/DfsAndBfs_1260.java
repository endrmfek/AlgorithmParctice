package dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsAndBfs_1260 {
	public static boolean[] checked = new boolean[1001];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int n,m,v;
	
	public static void dfs(int start) {
		
		checked[start] = true;
		System.out.print(start + " ");
		
		for(int i=0; i<graph.get(start).size(); i++) {
			int y = graph.get(start).get(i);
			if(!checked[y]) {
				dfs(y);
			}
		}
	}
	
	public static void bfs(int start) {
		checked[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			System.out.print(a + " ");
			
			for(int i=0; i<graph.get(a).size(); i++) {
				int y= graph.get(a).get(i);
				if(!checked[y]) {
					q.offer(y);
					checked[y] = true;
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		
		for (int i = 1; i <= n; i++) { 
			Collections.sort(graph.get(i)); 
		}

		
		
		dfs(v);
		System.out.println();
		Arrays.fill(checked, false);
		
		bfs(v);
	}
}
