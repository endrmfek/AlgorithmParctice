package programmers;

public class 거리두기확인하기 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visit;
	static int[] answer;
	
	public void dfs(int num, int x, int y, int count, String[] place) {
		//종료조건이 먼저 와야돼.
		if (count > 2) return;
		if (count > 0 && count <= 2 && place[x].charAt(y) == 'P') {
			answer[num] = 0;
			return;
		}
		
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < 5 && ny >=0 && ny <5) {
				if(place[nx].charAt(ny) != 'X') {
					if (visit[nx][ny]) continue; //와봤으면 가지마.
					visit[nx][ny] = true;
					dfs(num, nx, ny, count + 1 , place);
					visit[nx][ny] = false;
				}
			}
		}
	}
		
	public int[] solution(String[][] places) {
			answer = new int[places.length];
			
			for (int i=0; i<places.length; i++) {
				answer[i] = 1;
			}
			
			for(int i=0; i<places.length; i++) {
				visit = new boolean[5][5];
				for(int j=0; j<5; j++) {
					for(int k=0; k<5; k++) {
						if(places[i][j].charAt(k) == 'P') {
							visit[j][k] = true;
							dfs(i,j,k,0,places[i]);
							visit[j][k] = false;
						}
					}
				}
					
			}
			return answer;
	}
	
	
	
}
