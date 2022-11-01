import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        //n은 자연수 개수 , s는 target sum
        int[] answer = new int[n];
        if (n>s) {
            return new int[]{-1};
        }
        int share = s/n;
        int remainder = s%n;

        for(int i=0; i<n; i++) {
            answer[i] = share;
        }

        for(int i=0; i<remainder; i++) {
            answer[i]++;
        }

        Arrays.sort(answer);
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}