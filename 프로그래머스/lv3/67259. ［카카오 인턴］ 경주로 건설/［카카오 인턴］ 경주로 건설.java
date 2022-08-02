import java.util.*;
class Solution {
    static boolean[][][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int INF = (int) 1e9;
	static int n;
	static int answer = Integer.MAX_VALUE;
	public static int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n][4]; // 4방향으로 저장.
        bfs(board);
        return answer;
        
    }
	
	
	
	public static void bfs(int[][] board) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,-1,0));
		visited[0][0][0] = visited[0][0][1] = visited[0][0][2] = visited[0][0][3] = true;
		
		int min_cost = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			node now = q.poll();
			if(now.x == n-1 && now.y == n-1) answer = Math.min(answer, now.cost);
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx >=0 && ny >= 0 && nx<n && ny<n && board[nx][ny] != 1) {
					int next_cost = 0;
					if(now.dir == i || now.dir == -1) next_cost = now.cost + 100;
					else next_cost = now.cost+600;
					
					if(!visited[nx][ny][i] || board[nx][ny] >= next_cost) {
						q.add(new node(nx,ny,i,next_cost));
						visited[nx][ny][i] = true;
						board[nx][ny] = next_cost;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		solution(new int[][] {{0,0,0},{0,0,0},{0,0,0}});
	}
	
	static class node {
		int x;
		int y;
		int dir;
		int cost;
		node(int x, int y, int dir, int cost) {
			this.x =x ;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}
}