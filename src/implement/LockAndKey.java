package implement;

//답지 확인함..
//어렵지만 이해하려고 노력해라!!! 풀수있따

public class LockAndKey {
	
	public static int[][] rotate90(int[][] a) {
		int n = a.length; //행
		int m = a[0].length; //열
		int[][] result = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) { // 0,0 ->0,2  , 0,1 ->1,3
				result[j][n-i-1] = a[i][j];
			}
		}
		return result;
	}
	
	public static boolean check(int[][] newlock) {
		int lockLength = newlock.length / 3 ;
		for(int i=lockLength; i<lockLength*2; i++) {
			for(int j=lockLength; j<lockLength*2; j++) {
				if(newlock[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean solution(int[][] key, int[][] lock) {
		int n = lock.length; //자물쇠 크기
		int m = key.length;
		
		int[][] newLock = new int[n*3][n*3]; //3배로 변환.
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				newLock[i+n][j+n] = lock[i][j]; // 가운데다가 쳐넣어
			}
		}
		
		//4가지 방향에 대해서 확인
		for(int rotation=0; rotation<4; rotation++) {
			key = rotate90(key); //회전
			for(int x=0; x<n*2; x++) {
				for(int y=0; y<n*2; y++) {
					//모든 공간에 대해 끼워넣어봐.
					for(int i=0; i<m; i++) {
						for(int j=0; j<m; j++) {
							newLock[x+i][y+i] += key[i][j];
						}
					}
					
					if(check(newLock)) return true;
					
					//다시 빼..
					for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
				}
			}
		}

		return false;
	}
	

	public static void main(String[] args) {
		LockAndKey l = new LockAndKey();
		System.out.println(l.solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}} ));
	}
}
