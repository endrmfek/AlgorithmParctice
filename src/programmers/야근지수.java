package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class 야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        int sum = IntStream.of(works).sum();

        if(n>=sum) return 0;

        //works 원소 1개면?..
        if(works.length == 1) return (long) Math.pow((works[0]-n), 2);

        //2개 이상이면?
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2-o1));

        for (int work : works) {
            pq.add(work);
        }
        //4,3,3
        while(n > 0) {
            int top = pq.poll(); //
            int peek = pq.peek();
//            System.out.println(top + " , " + peek);
            while(top >= peek && n > 0) {
                top--;
                n--;
            }
            pq.add(top);
        }
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll() , 2);
        }

        return answer;
    }

    public long solution2(int n, int[] works) {
        long answer = 0;
        int lastIndex = works.length-1;

        for(int i=0; i<n; i++) {
            Arrays.sort(works);
            works[lastIndex]--;
        }

        for(int i=0; i<works.length; i++) {
            answer += Math.pow(works[i], 2);
        }
        return answer;
    }

    public static void main(String[] args) {
        야근지수 a = new 야근지수();
        System.out.println(a.solution2(4, new int[] {4,3,3}));
    }
}
