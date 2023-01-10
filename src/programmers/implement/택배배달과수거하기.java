package programmers.implement;

import java.util.Stack;

public class 택배배달과수거하기 {

    public long solution(int cap, int n, int[] deliveries , int[] pickups) {
        long answer = 0;

        int deli = n-1;
        int pick = n-1;

        while( deli >= 0 || pick >= 0) {

            //맨 마지막 유효숫자부터 시작하자.
            while(deli >=0 && deliveries[deli] == 0) deli--;
            while(pick >=0 && pickups[pick] == 0) pick--;

            // 맨 마지막 유효숫자를 갔다와라.
            answer += (Math.max(deli , pick)+1)*2L;

            //point 조정
            int box = 0;
            while(deli >=0 && box <= cap) {
                box += deliveries[deli];
                deliveries[deli--] = 0;
            }
            if(box > cap) {
                deliveries[++deli] = box-cap;
            }

            box = 0;
            while(pick >= 0 && box < cap) {
                box += pickups[pick];
                pickups[pick--] = 0;
            }
            if(box > cap) {
                pickups[++pick] = box-cap;
            }
        }
        return answer;
    }



    public long solution1(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();

        for(int i=0; i<n; i++) {
            if(deliveries[i] > 0) {
                dStack.add(i);
            }
            if(pickups[i] > 0) {
                pStack.add(i);
            }
        }

        while(!(dStack.isEmpty() || pStack.isEmpty())) {
            //가장 멀리부터 갔다와야돼.
            answer += Math.max((dStack.peek()+1) * 2 , (pStack.peek()+1)*2);

            int box = 0;
            while(!dStack.empty() && box <= cap) {
                if(deliveries[dStack.peek()] + box <= cap) { //담을 수 잇어?
                    box += deliveries[dStack.peek()];
                } else { //못참으면
                    deliveries[dStack.peek()] -= (cap - box);
                    break;
                }
                dStack.pop();
            }

            box = 0;
            while(!pStack.isEmpty() && box <= cap) {
                if(pickups[pStack.peek()] + box <= cap) {
                    box += pickups[pStack.peek()];
                } else {
                    pickups[pStack.peek()] -= (cap-box);
                    break;
                }
                pStack.pop();
            }
        }

        while(!dStack.isEmpty()) {
            answer+= (dStack.peek()+1) * 2;
            int box = 0;
            while(!dStack.empty() && box <= cap) {
                if(deliveries[dStack.peek()]+box <= cap) {
                    box += deliveries[dStack.peek()];
                }else {
                    deliveries[dStack.peek()] -= (cap-box);
                    break;
                }
                dStack.pop();
            }
        }

        while(!pStack.empty()) {
            answer += (pStack.peek()+1)*2;

            int box = 0;
            while(!pStack.empty() && box <= cap) {
                if(pickups[pStack.peek()]+box <= cap) {
                    box += pickups[pStack.peek()];
                }else {
                    pickups[pStack.peek()] -= (cap-box);
                    break;
                }
                pStack.pop();
            }
        }


        return answer;
    }

}
