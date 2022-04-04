package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreakingWall { // 벽 하나를 부수는게 어렵네..

	static class Node{
		private int x;
		private int y;
		private int dist;
		private int wall;
		
		public Node(int x, int y, int dist, int wall) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.wall = wall;
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

		public int getWall() {
			return wall;
		}
		
		

	}
	
	public static int[][] map, visit;
	public static int N, M, answer;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};
	
	public static Queue<Node> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		map = new int[N][M];
		visit = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = sc.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		answer = Integer.MAX_VALUE;
		
		bfs(0,0);
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(visit[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static void bfs(int x, int y) {
		q = new LinkedList<>();
		
		q.offer(new Node(x,y,1,0)); //이동거리, 공사횟수
		visit[x][y] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			int nowX = now.getX();
			int nowY = now.getY();
			
			if(nowX == N-1 && nowY == M-1) {
				answer = now.dist;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(visit[nx][ny] <= now.getWall()) continue;
				
			
				if(map[nx][ny] == 0) {
					visit[nx][ny] = now.getWall();
					q.offer(new Node(nx, ny, now.dist+1, now.getWall()));
						
				} else { // map[nx][ny] == 1 일때
					if(now.getWall() == 0) {
						visit[nx][ny] = now.getWall() + 1;
						q.offer(new Node(nx,ny,now.dist+1, now.getWall()+1));
					}	
				}
			}
					
		}
		
	}
	
}
