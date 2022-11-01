import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Solution {
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
            // System.out.println(top + " , " + peek);
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
}