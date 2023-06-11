package programmers;

import java.util.Arrays;

public class 요격시스템 {

    public int solution1(int[][] targets) {
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

    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2) -> {
            return o1[1]-o2[1];
        });

        int last = -1;
        for(int i=0; i<targets.length; i++) {
            if(last == -1) {
                answer++;
                last = targets[i][1] - 1;
                continue;
            }

            if(last >= targets[i][0] && last <= targets[i][1]) continue;

            answer++;
            last = targets[i][1] -1;
        }
        return answer;
    }
}
