package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tmt2 {
	private int h;
	private int x;
	private int y;
	
	Tmt2(int h, int x, int y) {
		this.h = h;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getH() {
		return h;
	}
}

public class Tomato2 {

	public static int H, M, N;
	
	public static int[] dh = {1,-1,0,0,0,0};
	public static int[] dx = {0,0,0,0,-1,1};
	public static int[] dy = {0,0,-1,1,0,0};
	
	public static int[][][] board;
	
	public static Queue<Tmt2> q = new LinkedList<Tmt2>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		
		board = new int[H][N][M];
		
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					board[k][i][j] = sc.nextInt();
					
					if(board[k][i][j] == 1) {
						q.offer(new Tmt2(k, i, j));
					}
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			Tmt2 t = q.poll();
			int h = t.getH();
			int x = t.getX();
			int y = t.getY();
			
			for(int i=0; i<6; i++) {
				int nh = h + dh[i];
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nh>=0 && nx >=0 && ny >= 0 && nh <H && nx <N && ny<M) {
					if(board[nh][nx][ny] == 0) {
						q.offer(new Tmt2(nh, nx, ny));
						board[nh][nx][ny] = board[h][x][y] + 1; 
					}
					
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
//					System.out.print(board[k][i][j] + " ");
					
					if(board[k][i][j] == 0) {
						return -1;
					}
					
					result = Math.max(result, board[k][i][j]);
				}
//				System.out.println();
			}
		}
		
		if(result == 1) {
			return 0;
		} else {
			return result -1;
		}
		
	}
}
