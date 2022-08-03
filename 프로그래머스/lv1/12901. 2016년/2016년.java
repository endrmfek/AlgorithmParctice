class Solution {
    public String solution(int a, int b) {
		//2016 1월1일 -> 금요일
		//1 : 31 , 2:29
		//2016 a월b일 -> ??
		//5월 24일 ->
        String answer = "";
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int date = 0;
        
        for(int i=0; i<a-1; i++) {
        	date += month[i];
        }
        
        date = date + (b-1);
        answer = day[date%7];
        
        return answer;
    }
}