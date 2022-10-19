package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_11438 {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] depth;
	static int kmax;
	static int[][] parent;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<=N; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i=0; i<N-1; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			tree.get(s).add(e);
			tree.get(e).add(s);
		}
		
		depth = new int[N+1];
		visited = new boolean[N+1];
		int temp = 1;
		kmax = 0;
		while(temp <= N) {
			temp = temp << 1;
			kmax++;
		}
		parent = new int[kmax+1][N+1];
		bfs(1);
		
		for(int k=1 ; k<=kmax; k++) {
			for(int n=1; n<=N; n++) {
				parent[k][n] = parent[k-1][parent[k-1][n]];
			}
		}
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
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
		int level = 1;
		int now_size =1;
		int count = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : tree.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
					parent[0][next] = now;
					depth[next] = level;
				}
			}
			count++;
			if(count == now_size) {
				count = 0;
				now_size = q.size();
				level++;
			}
		}
	}
	
	static int executeLca(int a, int b) {
		if(depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int k= kmax; k>=0; k--) {
			if(Math.pow(2,k) <= depth[b]- depth[a]) {
				if(depth[a] <= depth[parent[k][b]]) {
					b = parent[k][b];
				}
			}
		}
		
		for(int k= kmax; k>=0 && a != b; k--) {
			if(parent[k][a] != parent[k][b]) {
				a = parent[k][a];
				b = parent[k][b];
			}
		}
		int lca = a;
		if( a != b) {
			lca = parent[0][lca];
		}
		return lca;
	}
}
