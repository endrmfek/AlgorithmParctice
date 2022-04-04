package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Tmt {
	private int x;
	private int y;
	
	Tmt(int x, int y) {
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

public class Tomato {
	
	public static int n,m;
	public static int[][] board;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,-1,0,1};
	
	public static Queue<Tmt> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		board = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == 1) {
					q.offer(new Tmt(i, j));
				}
			}
		}
		
		System.out.println(bfs());
		
	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			Tmt t = q.poll();
			int x = t.getX();
			int y = t.getY();
			
			for(int i=0; i<4; i++ ) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >=0 && nx<n && ny >=0 && ny <m ) {
					if(board[nx][ny] == 0) {
						q.add(new Tmt(nx, ny));
						
						//날자 표시를 해줘야지.
						board[nx][ny] = board[x][y] +1;
					}
				}
			}
					
		}
		
		int result = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
//				System.out.print(board[i][j] + " ");
				
				if(board[i][j] == 0) {
					return -1;
				}
				
				result = Math.max(result, board[i][j]);
			}
//			System.out.println();
		}
		
		if(result == 1) {
			return 0;
		}
		else  {
			return result -1;
		}
	}
}
