package programmers;

import java.util.LinkedList;
import java.util.Queue;


public class 게임맵최단거리 {
	// n x m 크기.
	public static int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        int[][] visited = new int[n][m];
        
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {0,0});
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
        	Integer[] start = q.poll();
        	
        	for(int i=0; i<4; i++) {
        		int nx = start[0] + dx[i];
        		int ny = start[1] + dy[i];
        		
        		if (0<=nx && nx < n && 0<=ny && ny<m) {
        			if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
        				q.add(new Integer[] {nx,ny});
        				visited[nx][ny] = visited[start[0]][start[1]] + 1;
        			}
        		}
        	}
        }
        
        if (visited[n-1][m-1] == 0) {
        	answer = -1;
        } else {
        	answer = visited[n-1][m-1];
        }
        
        for(int i=0; i<n; i++) {
        	for (int j=0; j<m; j++) {
        		System.out.print(visited[i][j] + " ");
        	}
        	System.out.println();
        }
        return answer;
    }
	
	public static void main(String[] args) {
		solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
	}
	
}
