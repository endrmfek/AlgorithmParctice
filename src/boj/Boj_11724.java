package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11724 {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int count = 0;
		visited = new boolean[v+1];
		
		for(int i=0; i<v+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i=1; i<v+1; i++) {
			if(visited[i] == false) {
				count++;
				dfs(i);
			}
		}
		
		System.out.println(count);
	}
	
	static void dfs(int start) {
		if(visited[start] == true) {
			return;
		}
		
		visited[start] = true;
		for(int i=0; i<graph.get(start).size(); i++) {
			int next =graph.get(start).get(i);
			if(visited[next] == false) {
				dfs(next);
			}
		}
	}
}
