package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//지뢰 찾기
public class NumberThree {
	
	static int[] dx = {-1, -1 ,0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1 ,-1,-1};
	
	public static String[] solution(String[] board, int x, int y) {
        String[] answer = new String[board.length];
        StringBuilder sb = new StringBuilder();
        //(2,0)
        
        //지뢰 M , 아닌거 E
        
        char[][] graph = new char[board.length][board[0].length()];
        boolean[][] visited = new boolean[board.length][board[0].length()];
        for(int i=0; i<board.length; i++) {
        	char[] row = board[i].toCharArray();
        	for(int j=0; j<row.length; j++) {
        		if(row[j] == 'M') {
        			graph[i][j] = 'M';
        		} else {
        			graph[i][j] = 'E';
        		}
        	}
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        
        //바로 밟았으면
        if(graph[x][y] == 'M') {
        	graph[x][y] = 'X';
        	for(int i=0; i<board.length; i++) {
        		answer[i] = sb.append(graph[i]).toString();
            	sb.setLength(0);
        	}
        	return answer;
        }
        
        
        while( !q.isEmpty()) {
        	int[] start = q.poll();
        	int nowX = start[0];
        	int nowY = start[1];
        	int bug = 0;
        	visited[nowX][nowY] = true;
        	//지뢰 찾어
        	for(int i=0; i<8; i++) {
        		int nx = nowX + dx[i];
        		int ny = nowY + dy[i];
        		
        		if(nx >= 0 && nx <board.length && ny >=0 && ny < board[0].length() && !visited[nx][ny]) {
        			//버그가 발견되는 곳에서는 큐에 넣지 말아야되는데..
        			if(graph[nx][ny] == 'M') {
        				bug += 1;
        			} 
        		}
//        		System.out.println(nowX + " " + nowY + " " + nx + " " + ny + " " +bug);
        	}
        	
        	if(bug != 0) {	
        		graph[nowX][nowY] = (char) (bug + '0');
    		} 
        	else {
        		for(int i=0; i<8; i++) {
            		int nx = nowX + dx[i];
            		int ny = nowY + dy[i];
            		
            		if(nx >= 0 && nx <board.length && ny >=0 && ny < board[0].length() && !visited[nx][ny]) {
            			q.add(new int[] {nx,ny});
            		}
            	}
        		graph[nowX][nowY] = 'B';
    		}
        }
        
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length(); j++) {
        		if (graph[i][j] == 'M') {
        			graph[i][j] = 'E';
        		}
        	}
        }
        
        for(int i=0; i<board.length; i++) {
        	
        	answer[i] = sb.append(graph[i]).toString();
        	sb.setLength(0);
        	
    	}
        
        return answer;
    }
	
	public static void main(String[] args) {
//		{"EEEEE", "EEMEE", "EEEEE", "EEEEE"}, 2, 0)
		solution(new String[] {"EEEEE", "EEMEE", "EEEEE", "EEEEE"}, 2, 0);
		
	}
}
