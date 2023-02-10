package programmers.implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i< progresses.length; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.add(day);
        }

        List<Integer> result = new ArrayList<>();
        while(q.isEmpty()) {
            int day = q.poll();
            int count = 1;

            while(!q.isEmpty() && q.peek() <= day) {
                q.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
