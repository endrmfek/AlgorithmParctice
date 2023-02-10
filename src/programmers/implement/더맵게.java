package programmers.implement;

import java.util.PriorityQueue;

public class 더맵게 {
    //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int s : scoville) {
            q.add(s);
        }

        while(q.peek() <= K) {
            int first = q.poll();
            int second = q.poll();

            int newScoville = first + (second * 2);
            q.add(newScoville);
            answer++;

            if(q.size() == 1 && q.peek() < K) {
                return -1;
            }
        }

        return answer;
    }
}
