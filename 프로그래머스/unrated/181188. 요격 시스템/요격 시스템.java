import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2) -> {
            return o1[1]-o2[1];
        });

        int last = -1;
        for(int[] target : targets) {
            if(target[0] < last) {
                continue;
            } else {
                answer++;
                last = target[1];
            }
        }
        return answer;
    }
}