package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MoveKnight {
	
	static class Node {
		private int x;
		private int y;
		private int dist;
		
		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
		public int getDist() {
			return dist;
		}
		
		
	}
	
	public static int[][] board;
	public static int[][] visited;
	public static int n;
	
	public static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	public static int[] dy = {-2,-1,1,2,2,1,-1,-2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=0; t<tc; t++) {
			n = sc.nextInt();
			
			board = new int[n][n];
			visited = new int[n][n];
			int knightX = sc.nextInt();
			int knightY = sc.nextInt();
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			board[x][y] = 1;
			
			if(board[knightX][knightY] == 1) {
				System.out.println(0);
			} else {
				System.out.println(bfs(knightX, knightY));
			}
			
		}
	
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int nowX = now.getX();
			int nowY = now.getY();
			
			for(int i=0; i<8; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				
				if(nx <0 || nx>=n || ny<0 || ny >=n) continue;
				
				if(board[nx][ny]== 1) return now.getDist()+1;
				
				if(visited[nx][ny] == 0) {
					visited[nx][ny] = now.getDist() + 1;
					q.offer(new Node(nx,ny,now.getDist()+1));
				}
				
			
			}
		}
		
		return -1;
		
	}
}
