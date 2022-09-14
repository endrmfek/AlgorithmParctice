package programmers;

import java.util.PriorityQueue;

public class 셔틀버스 {
	public String solution(int n, int t, int m, String[] timetable) {
        //셔틀은 9:00 부터 n회 t분 간격으로 최대 m명의 승객
		//가장 늦은 시각.
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable) {
        	Integer clock = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
        	pq.add(clock);
        }
        
        int start = 9 * 60;
        int myTime = 0;
        
        int count =0; // 사람 카운트
        for(int i=0; i<n; i++) { //n회 돌잖아.
        	count = 0; //매 버스 0부터 시작해야돼
        	while(!pq.isEmpty()) { //사람이 다 사라질때까지.
        		int first = pq.peek(); // 맨 앞사람 시간을 봐바
        		
        		if(first <= start && count<m) { // 사람 비었고, 제시간에 탈수 있어.
        			pq.poll();
        			count++;
        		} else { // 제시간에 탈수 없거나, 사람이 꽉차면 다음버스로.
        			break;
        		}
        		myTime = first -1; //최소 1초빨리 가야대
        	}
        	start = start + t; //다음 버스로.
        }
        if(count < m) myTime = start - t;
        
        String hour = String.format("%02d", myTime / 60);
        String minute = String.format("%02d" , myTime% 60);
        
        return hour+":"+minute;
    }
}
