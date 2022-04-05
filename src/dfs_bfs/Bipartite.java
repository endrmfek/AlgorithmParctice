package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<ArrayList<Integer>> arrayLists;
	
	static final int RED = 1;
	static final int BLUE = -1;
	static int[] colors;
	static boolean checkBipartite;
	
	public static void main(String[] args) {
		int testCase = sc.nextInt();
		
		while(testCase-- > 0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			arrayLists = new ArrayList<>();
			colors = new int[V+1]; // 각 정점의 색
			checkBipartite = true; // 초기는 참이라고 가정
			
			for(int i=0; i<V+1; i++) {
				arrayLists.add(new ArrayList<Integer>());
				colors[i] = 0;
			}
			
			while(E-- > 0) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				
				arrayLists.get(v1).add(v2);
				arrayLists.get(v2).add(v1); // 양방향 그래프
			}
			 
			for(int i=1; i<V+1; i++) {
				if(!checkBipartite) break;
				
				if(colors[i] == 0) {
					bfs(i, RED);
				}
			}
			
			System.out.println(checkBipartite ? "YES" : "NO");
		}
	}
	
	static void bfs(int startV, int color) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(startV);
		colors[startV] = color;
		
		while(!q.isEmpty() && checkBipartite) {
			int v = q.poll();
			
			for(int adjv : arrayLists.get(v)) {
				
				if(colors[adjv] == 0) {
					q.offer(adjv);
					colors[adjv] = colors[v] * -1;
				} else if(colors[v] + colors[adjv] != 0) {
					checkBipartite = false;
					return;
				}
				
			}
			
		}
	}
	
	static void dfs(int startV, int color) {
		colors[startV] = color;
		
		for(int adjv : arrayLists.get(startV)) {
			if(colors[adjv] == color) {
				checkBipartite = false;
				return;
			}
			
			if(colors[adjv] == 0) {
				dfs(adjv, -color);
			}
		}
	}
}
