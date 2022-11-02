package programmers;

import java.math.BigInteger;
import java.util.*;

public class lv2 {


    //가로 w cm
    //세로 H cm
    //1 x 1
    //대각선 꼭지점 2개를 잇는 방향.
    //시발 이거 그거잖아 ㅈ같은문제.
    public long solution1(int w, int h) {
        long answer = 1;
        long gcd = gcd(w,h);

        return ((long) w *h) - (w+h-(int) gcd);
    }

    private static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }

    public List solution2(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int time = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.offer(time);
        }

        while(!q.isEmpty()) {
            int count = 1;
            int day = q.poll();

            while(!q.isEmpty() && day >= q.peek()) {
                q.poll();
                count++;
            }
            answer.add(count);
        }

        return answer;
    }


    public static void main(String[] args) {
        lv2 a = new lv2();
//        a.solution(new String[][]
//                {{"100","ryan","music","2"},
//                {"200","apeach","math","2"},
//                {"300","tube","computer","3"},
//                {"400","con","computer","4"},
//                {"500","muzi","music","3"},
//                {"600","apeach","music","2"}}
//        );


    }
}
