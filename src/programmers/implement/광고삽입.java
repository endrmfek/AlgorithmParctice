package programmers.implement;

import java.util.Arrays;

public class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = timeToInt(play_time);
        int advTime = timeToInt(adv_time);
        int[] totalTime = new int[playTime + 1]; // 0 ~ playTime까쥐.

        for(String log : logs) {
            String[] splitLog = log.split("-");
            int startTime = timeToInt(splitLog[0]);
            int endTime = timeToInt(splitLog[1]);

            for(int i= startTime; i<endTime; i++) {
                totalTime[i]++;
            }
        }

        long sum = 0;
        for(int i=0; i<advTime; i++) {
            sum += totalTime[i];
        }
        long max_sum = sum;
        int index = 0;

        for(int i=advTime; i<playTime; i++) {
            sum += totalTime[i] - totalTime[i-advTime];
            if(sum > max_sum) {
                max_sum = sum;
                index = i-advTime+1;

            }
        }

        return intToTime(index);
    }

    int timeToInt(String time) {
        String[] hhmmss = time.split(":");
        int h = Integer.parseInt(hhmmss[0]) * 3600;
        int m = Integer.parseInt(hhmmss[1]) * 60;
        int s = Integer.parseInt(hhmmss[2]);
        return h+m+s;
    }

    String intToTime(int time) {
        StringBuilder sb = new StringBuilder();
        int h = time / 3600;
        if (h>9) {
            sb.append(h);
        }else {
            sb.append(0).append(h);
        }
        sb.append(":") ;
        time %= 3600;
        int m = time / 60;
        if(m > 9) {
            sb.append(m);
        }else {
            sb.append(0).append(m);
        }
        sb.append(":");
        time %= 60;
        int s = time;
        if(s>9) {
            sb.append(s);
        }else {
            sb.append(0).append(s);
        }
        return sb.toString();
    }

    //시간계산 메소드도 하나 넣으면 좋겠는데.
    public static void main(String[] args) {
        광고삽입 a = new 광고삽입();
        System.out.println(a.solution(	"99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
    }
}
