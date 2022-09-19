class Solution {
    //이걸 코드로 어떻게 구현하노?..
	/*
    [[1,1,1,1,1,1,1,1],
     [0,1,1,1,1,1,1,1],
     [0,0,0,0,1,1,1,1],
     [0,1,0,0,1,1,1,1],
     [0,0,0,0,0,0,1,1],
     [0,0,0,0,0,0,0,1],
     [0,0,0,0,1,0,0,1],
     [0,0,0,0,1,1,1,1]]
     */
    
    //재귀로 해결한다 (힌트)
	static int zero = 0;
	static int one = 0;
    public int[] solution(int[][] arr) {
    	
        int[] answer = {};
        recursion(arr, 0, arr.length-1, 0, arr[0].length-1);
        
        //0의 개수 , 1의 개수
        return new int[] {zero , one};
    }
    
    public void recursion(int[][] arr, int startX , int endX, int startY, int endY) {
    	//0 , 7, 0 , 7 -> (0,3,0,3) , (0,3,4,7), (4,7,0,3) (4,7,4,7)
    	int findNumber = arr[startX][startY];
    	boolean allMatch = true;
    	
    	loop:
    	for(int i=startX; i<=endX; i++) {
    		for(int j=startY; j<=endY; j++ ) {
    			if(findNumber != arr[i][j]) {
    				allMatch = false;
    				break loop;
    			}
    		}
    	}
    	
    	if(allMatch) {
    		if (findNumber == 0) {
    			zero++;
    		} else {
    			one++;
    		}
    		return;
    	}
    	
    	recursion(arr, startX, (startX+endX)/2, startY, (startY+endY)/2); //좌상
    	recursion(arr, startX, (startX+endX)/2, ((startY+endY)/2) +1, endY); //우상
    	recursion(arr, ((startX+endX)/2) +1, endX, startY, (startY+endY)/2); //좌하
    	recursion(arr, ((startX+endX)/2) +1, endX, ((startY+endY)/2) +1, endY); //우하
    }
}