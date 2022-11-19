import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right =(long) times[times.length-1]*n;

        while(left <= right) {
            long mid = (left + right) / 2;

            long total = 0;
            for(int time : times) {
                total += (mid / time);
            }
            if( total < n) {
                left = mid+1;
            } else {
                right = mid-1;
                answer = mid;
            }
        }
        return answer;
    }
}