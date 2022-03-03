package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Floyd2 {

	public static final int INF = (int) 1e9;
	public static int n, m; // 노드 , 간선
	public static int[][] graph = new int[101][101]; // 플로이드는 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<101; i++) {
			Arrays.fill(graph[i], INF); //2차원 배열 초기화
		}
		
		for(int i=1; i<=n; i++) { // 같은 지점 0으로 초기화
			for(int j=1; j<=n; j++) {
				if(i==j) graph[i][j] = 0;
			}
		}
		
		for(int i=0; i<m; i++) { //간선 개수만큼 입력받아서 그래프 초기화
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(c < graph[a][b]) graph[a][b] = c; // 짧은 간선만 저장
		}
		
		for(int i=1; i<=n; i++) {
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					graph[a][b] = Math.min(graph[a][b] , graph[a][i]+ graph[i][b]);
				}
			}
		}
		
		for(int a=1; a<=n; a++) {
			for(int b=1; b<=n; b++) {
				if(graph[a][b] == INF) {
					System.out.print(0 + " ");
				} else {
					System.out.print(graph[a][b] + " ");
				}
			}
			System.out.println();
		}
	}
	
}
