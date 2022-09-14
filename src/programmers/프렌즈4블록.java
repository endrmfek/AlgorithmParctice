package programmers;

public class 프렌즈4블록 {
	
//	int[][][] direction= {
//							{{0,-1,-1,0},{0,0,-1,-1}},
//							{{0,-1,-1,0},{0,0,1,1}}, 
//							{{0,0,1,1},{0,-1,-1,0}}, 
//							{{0,0,1,1},{0,1,1,0} }
//						}; //왼쪽 위
//	int[] luy = ;
//	
//	int[] rux = {0,-1,-1,0}; //오른쪽 위
//	int[] ruy = {0,0,1,1};
//	
//	int[] ldx = {0,0,1,1}; // 왼쪽 아래
//	int[] ldy = {0,-1,-1,0};
//	
//	int[] rdx = {0,0,1,1}; // 오른쪽 아래
//	int[] rdy = {0,1,1,0};
	
	public int solution(int m, int n, String[] board) {
        // 높이 m, 길이 n, 
        // 2<= n,m <=30
        int answer = 0;
        char[][] map = new char[m][n];
        
        for(int i=0; i<m; i++) {
        	map[i] = board[i].toCharArray();
        }
        
        while(true) {
        	int cnt = check(m,n,map);
        	if(cnt == 0) break;
        	answer += cnt;
        	
        	dropBlock(m,n,map);
        }
        
        
        return answer;
    }
	
	public int check(int m, int n, char[][] map) {
		int cnt = 0;
		boolean[][] isChecked = new boolean[m][n];
		
		for(int i=0; i<m-1; i++) { // 모든 공간에 대해 4개 찍어
			for(int j=0; j<n-1; j++) {
				if(map[i][j] == '.') continue;
				checkFour(map, isChecked, i, j);
			}
		}
		
		for(int i=0; i<m; i++) {// 지운곳 '.'으로 바꿔
			for(int j=0; j<n; j++) {
				if(isChecked[i][j]) {
					cnt++;
					map[i][j] = '.';
				}
			}
		}
		return cnt;
		
	}
	
	public void checkFour(char[][] map, boolean[][] isChecked, int i , int j) {
		char block = map[i][j];
		
		for(int r=i; r<i+2; r++) {
			for(int c=j; c<j+2; c++) {
				if(map[r][c] != block) return;
			}
		}
		
		for(int r=i; r<i+2; r++) {
			for(int c=j; c<j+2; c++) {
				isChecked[r][c] = true;
			}
		}
	}
	
	public void dropBlock(int m, int n, char[][] map) { //맨밑이0이잖아
		for(int c=0; c<n; c++) { // 컬럼별로
			for(int r=m-1; r>=0; r--) { //맨위부터 아래까지 r= 5
				if(map[r][c] == '.') { // 빈곳이면
					
					for(int nr = r-1; nr >=0; nr--) { // 내려 0까지 nr 4
						if(map[nr][c] != '.') { // 아래가 비었으면
							
							map[r][c] = map[nr][c]; //위로 올려?..
							map[nr][c] = '.';
							break;
						}
					}
				}
			}
		}
	}
}
