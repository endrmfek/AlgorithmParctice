package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Boj_11437 {
	//최소 공통 조상 찾기 -> 트리.
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] depth; //깊이 있어야되고
	static int[] parent; // 
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<=n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i=0; i<n-1; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			tree.get(s).add(e);
			tree.get(e).add(s);
		}
		
		depth = new int[n+1];
		parent = new int[n+1];
		visited = new boolean[n+1];
		
		bfs(1); // depth랑 parent 알아야돼.
		
		int m = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int lca = executeLca(a, b);
			System.out.println(lca);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		//여기서 해야될게 depth, parent 초기화잖아
		int level = 1;
		int now_size = 1;
		int count = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : tree.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
					parent[next] = now;
					depth[next] = level;
					q.add(next);
				}
			}
			count++;
			if(count == now_size) {
				count = 0;
				now_size = q.size();
				level++; //깊이 추가
			}
		}
	}
	
	static int executeLca(int a, int b) {
		//a를 기준으로 한다면
		if(depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		//높이 차이를 맞춰야겠지
		while(depth[a] != depth[b]) {
			a = parent[a];
		}
		
		while (a != b ) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}
		
}
