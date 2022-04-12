package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_13023 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static boolean arrive;
	
	public static void main(String[] args) throws IOException{ // 재귀는 종료조건에 따라 변형 가능.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		visited = new boolean[v];
		for(int i=0; i<v; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b); // 양방향?..
			graph.get(b).add(a);
		}
		
		
		for(int i=0; i<v; i++) {
			dfs(i, 1); // 깊이 1부터 5까지
			if(arrive) break;
		}
		
		if(arrive) System.out.println("1");
		else System.out.println("0");
	}
	
	static void dfs(int start, int depth) {
		if(depth== 5 || arrive) {
			arrive = true;
			return;
		}
		
		visited[start] = true;
		
		for(int i=0; i<graph.get(start).size(); i++) {
			int next = graph.get(start).get(i);
			if(!visited[next]) {
				dfs(next, depth+1);
			}
		}
		
		visited[start] = false;
	}
}
