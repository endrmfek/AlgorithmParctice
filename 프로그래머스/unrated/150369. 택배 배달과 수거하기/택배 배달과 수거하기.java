import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries , int[] pickups) {
        long answer = 0;

        int deli = n-1;
        int pick = n-1;

        while( deli >= 0 || pick >= 0) {

            //맨 마지막 유효숫자부터 시작하자.
            while(deli >=0 && deliveries[deli] == 0) deli--;
            while(pick >=0 && pickups[pick] == 0) pick--;

            // 맨 마지막 유효숫자를 갔다와라.
            answer += (Math.max(deli , pick)+1)*2L;

            //point 조정
            int box = 0;
            while(deli >=0 && box <= cap) {
                box += deliveries[deli];
                deliveries[deli--] = 0;
            }
            if(box > cap) {
                deliveries[++deli] = box-cap;
            }

            box = 0;
            while(pick >= 0 && box < cap) {
                box += pickups[pick];
                pickups[pick--] = 0;
            }
            if(box > cap) {
                pickups[++pick] = box-cap;
            }
        }
        return answer;
    }
}