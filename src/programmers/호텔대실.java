package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 호텔 대실
 * 10분간 청소를하고 다음손님 사용가능.
 * 최소 객실의 수
 * String[][] -> ["HH:MM","HH:MM"]
 * */
public class 호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;

        Arrays.sort(book_time, (original, compare) -> {
            int originalStartTime = getTime(original[0].split(":"));
            int compareStartTime = getTime(compare[0].split(":"));
            int originalEndTime = getTime(compare[1].split(":"));
            int compareEndTime = getTime(compare[1].split(":"));

            //2. 시작시간이 같으면 종료시간이 빠른순서대로
            if(originalStartTime == compareStartTime) {
                return originalEndTime - compareEndTime ;
            }
            //1. 시작시간이 빠른 순서대로
            return originalStartTime - compareStartTime;
        });

        //최소힙 -> 가장 빨리 끝나는 방
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<book_time.length; i++) {
            int startTime = getTime(book_time[i][0].split(":"));
            int endTime = getTime(book_time[i][1].split(":")) + 10; // 청소시간 포함

            //처음엔 무조건 삽입
            if(i == 0) {
                pq.add(endTime);
                continue;
            }

            int lastRoomEndTime = pq.peek();
            if(startTime >= lastRoomEndTime) {
                pq.poll();
                pq.add(endTime);
            } else {
                pq.add(endTime);
            }

        }
        return pq.size();
    }

    public int getTime(String[] time) {
         int hour = Integer.parseInt(time[0]) * 60;
         int minute = Integer.parseInt(time[1]);

         return hour + minute;
    }
}
