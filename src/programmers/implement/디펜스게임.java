package programmers.implement;

import java.util.*;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {

        Queue<Integer> pq = new PriorityQueue<>();
        //필살기를 하나의 범위로 보자.
        for(int i=0; i<enemy.length; i++) {
            pq.add(enemy[i]);

            if(pq.size() > k) { // 처리해야되는 라운드가 필살기보다 많으면
                n -= pq.poll();
            }

            if(n<0) return i;
        }

        return enemy.length;
    }
}
