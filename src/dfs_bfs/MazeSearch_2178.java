package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node_m {
	private int x;
	private int y;
	
	public Node_m(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
}

public class MazeSearch_2178 {
	static int n, m;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int graph[][] = new int[102][102];
	
	public static void bfs(int x, int y) {
		Queue<Node_m> q = new LinkedList<>();
		q.offer(new Node_m(x, y));
		
		while(!q.isEmpty()) {
			Node_m node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >=n || ny <0 || ny >= m) continue;
				
				if(graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] + 1;
					q.offer(new Node_m(nx, ny));
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
			String str = sc.nextLine();
			for(int j=0; j<m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0,0);
		System.out.println(graph[n-1][m-1]);
	}
}
