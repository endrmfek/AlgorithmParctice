package programmers;

public class 행렬덧셈 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		// 2*2 행렬이라 치면
		// (0,0) (0,1) //0행 0렬 (0,0) , 0행 1렬 (0,1)
		// (1,0) (1,1)
        int[][] answer = new int[arr1.length][arr1.length];
        
        for(int i=0; i<arr1.length; i++) {
        	
        	for (int j=0; j<arr1.length; j++) {
        		answer[i][j] = arr1[i][j] + arr2[i][j];
        	}
        	
        }
        return answer;
    }
}
