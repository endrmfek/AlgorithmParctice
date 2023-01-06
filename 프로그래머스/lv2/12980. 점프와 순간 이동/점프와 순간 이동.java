import java.util.*;

public class Solution {
    //건전지 최솟값.
    //dp문제임.
    public static int solution(int n) { // 실패
        int answer = 0;
        //매 순간 갈 수 있는 경우의 수
        
        while(n != 0) {
            if(n%2 == 0) {
                n = n/2;
            } else {
                n--;
                answer++;
            }
        }
        return answer++;
    }
}