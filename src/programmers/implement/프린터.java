package programmers.implement;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

    static class Item {
        int value;
        int index;

        public Item(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Item> q = new LinkedList<>();

        for(int i=0; i< priorities.length; i++) {
            q.add(new Item(priorities[i], i));
        }

        while(!q.isEmpty()) {
            Item item = q.poll();
            boolean flag = false;

            for(Item i : q) {
                if(item.value < i.value) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                q.add(item);
            } else { //우선순위가 제일 큼?
                answer++;
                if(item.index == location) {
                    return answer;
                }
            }
        }
        return 0;
    }
}
