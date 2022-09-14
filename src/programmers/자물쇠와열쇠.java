package programmers;

public class 자물쇠와열쇠 {
	
	public static int[][] rotateMatrix(int[][] a) { // 90도 돌리는거.
		int n = a.length;
		int m = a[0].length;
		int[][] result = new int[n][m];
		
		for (int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				result[j][n-i-1] = a[i][j];
			}
		}
		return result;
	}
	
	public static boolean check(int[][] newLock) { //가운데만 체크
		int lockLength = newLock.length/3; // 3배 줄인거.
		for (int i=lockLength; i<lockLength *2; i++) {
			for(int j=lockLength; j<lockLength * 2; j++) {
				if(newLock[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        int n = lock.length;
        int m = key.length;
        
        int[][] bigLock = new int[n*3][n*3];
        
        //초기화..
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		bigLock[i+n][j+n] = lock[i][j];
        	}
        }
        
        // 3n*3n 짜리 다 돌면서 체크를 박아야돼.
        for(int r=0; r<4; r++) { // 4방향으로
        	key = rotateMatrix(key);
        	
        	for(int x=0; x<2*n; x++) { //자물쇠 모든 공간에 대해
        		for(int y=0; y<2*n; y++) {
        			
        			for(int i=0; i<m; i++) {
        				for(int j=0; j<m; j++) {
        					bigLock[x+i][y+j] += key[i][j];
        				}
        			}
        			
        			if(check(bigLock)) return true;
        			
        			for(int i=0; i<m; i++) {
        				for(int j=0; j<m; j++) {
        					bigLock[x+i][y+j] -= key[i][j];
        				}
        			}
        		}
        	}
        }
        
        return false;
	}
}
