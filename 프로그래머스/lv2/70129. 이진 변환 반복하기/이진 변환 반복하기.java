class Solution {
    public int[] solution(String s) {
        
        int count = 0; //변환횟수
        int zeroCount = 0; //제거된 0dml ghlttn
        String str = s;
        
        while(!str.equals("1")) {
        	//0을제거
        	String temp = str.replace("0", "");
        	int tempSize = temp.length();
        	zeroCount += str.length() - tempSize;
        	
        	//길이 -> 2진법으로
        	str = Integer.toString(tempSize, 2);
        	count += 1;
        }
        
        return new int[] {count , zeroCount};
    }
}