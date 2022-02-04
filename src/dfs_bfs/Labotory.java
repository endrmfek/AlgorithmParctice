package dfs_bfs;

import java.util.Scanner;

//0 빈칸 1 벽 2 바이러스

public class Labotory {
	public static int n,m, result=0;
	public static int[][] graph = new int[8][8]; //초기 설정 ,  벽 세워
	public static int[][] temp = new int[8][8]; //바이러스 퍼졌을때.
	
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static void virus(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && nx <n && ny >=0 && ny <m) { // 범위 안에 있고
				if(temp[nx][ny] == 0) { // 빈공간이라면
					temp[nx][ny] = 2;
					virus(nx, ny);
				}
			}
		}
	}
	
	public static int getScore() {
		int score = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j] == 0) {
					score += 1;
				}
			}
		}
		return score;
	}
	
	//깊이우선 탐색을 하면서 안전영역을 계산해라.?
	
	public static void dfs(int count) {
		if(count == 3) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					temp[i][j] = graph[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(temp[i][j]==2) {
						virus(i, j);
					}
				}
			}
			result = Math.max(result, getScore());
			return;
		}
		
		for(int i=0; i<n; i++) { //이 부분 combination으로도 할수잇지 않을까?
			for(int j=0; j<m; j++) {
				if(graph[i][j]==0) {
					graph[i][j] = 1;
					count += 1;
					dfs(count);
					graph[i][j] = 0;
					count -= 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(result);
	}
}
