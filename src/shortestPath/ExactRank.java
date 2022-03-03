package shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class ExactRank {
	public static final int INF = (int) 1e9;
	public static int n,m;
	public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<501; i++) {
			Arrays.fill(graph, INF);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++ ) {
				if(i==j) graph[i][j] = 0;				
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph[a][b] = 1;
			}
		}
		
		//노드개수가 500이면 플로이드 가능
		for(int i=1; i<=n; i++) {
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
				}
			}
		}
		
		int result = 0;
		for(int i=1; i<=n; i++) {
			int cnt =0; 
			for(int j=1; j<=n; j++) {
				if(graph[i][j] != INF || graph[j][i] != INF) {
					cnt += 1;
				}
			}
			if( cnt == n) {
				result += 1;
			}
		}
		
		System.out.println(result);
	}
}
