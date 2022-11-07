package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    //[[0, 3], [1, 9], [2, 6]]
    //최적의 시간? 이것도이진탐색으로 가능할거같은데.. -> 나중에 고려해보자.
    //일단 우선순위 큐.
    public int solution(int[][] jobs) {
        int answer = 0;
        int start = -1; // 시작점.
        int now = 0; // 끝점?
        int index = 0; // jobs 개수.
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        while(index < jobs.length) {
            for(int[] job : jobs) {
                if(start < job[0] && job[0] <=now) {
                    pq.add(job);
                }
            }

            if(pq.size() > 0) { // 뭐라도 잇으면
                int[] data = pq.poll();
                start = now;
                now += data[1];
                answer += now - data[0];
                index++;
            } else {
                now++;
            }

        }
        return answer/ jobs.length;
    }
}
