package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao1 {
	//개인 정보 n
    //유효기간
    //모든 달은 28일까지?? 
    //오늘 2022.5.19
    //오늘날짜 -> today , 유효기간 -> terms , 개인정보 ->privacies
    //개인정보 오름차순
    public static List<Integer> solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<>();
        //28일이 1달.
        //일수로 바꿔서 계산 가능?
        
        Map<String, Integer> term = new HashMap<>();
        for(String t : terms) {
            String[] termData = t.split(" ");
            term.put(termData[0] , Integer.parseInt(termData[1])); // 일수로 바꾸자. 
        }

        for(int i=0; i<privacies.length; i++) {
            String[] privacyData = privacies[i].split(" ");
            String date = privacyData[0]; // 날짜
            String alpha = privacyData[1]; // 등급
            
            boolean possible = dayCalc(today, date, term.get(alpha));
            if(possible) {
                answer.add(i+1);
            }
            
        }
        return answer;
    }

    public static boolean dayCalc(String today, String target, int alpha) {
        String[] todayData = today.split("[.]");
        int todayYear = Integer.parseInt(todayData[0]);
        int todayMonth = Integer.parseInt(todayData[1]);
        int todayDay = Integer.parseInt(todayData[2]);
        //2022-05-19
        String[] targetData = target.split("[.]");
        int targetYear = Integer.parseInt(targetData[0]);
        int targetMonth = Integer.parseInt(targetData[1]);
        int targetDay = Integer.parseInt(targetData[2]);
        //2021-05-02 + 6달 -> 28 * 6 계산 어케 하지..

        for(int i=1; i<=alpha; i++) {
            targetDay += 28;
            if(targetDay > 28) {
                targetDay = targetDay % 28;
                targetMonth += 1;
            }
            if(targetMonth>12) {
                targetMonth = targetMonth % 12;
                targetYear += 1;
            }
        }
        
        
        
        String todayDate = String.valueOf(todayYear) + String.format("%02d", todayMonth) + String.format("%02d",todayDay);
        String calcDay = String.valueOf(targetYear) + String.format("%02d",targetMonth) + String.format("%02d",targetDay);
        System.out.println(todayDate + " " + calcDay);
        int calc = Integer.parseInt(todayDate) - (Integer.parseInt(calcDay)-1);
        //2022 - 06 - 02 > 2021
        
        if(calc >0 ) {
        	//담을수있어
        	return true;
        } else {
        	return false;
        }
        
    }
    public static void main(String[] args) {
		solution("2002.05.19", new String[] {"A 6" , "B 12", "C 3"}, new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" });
	}
}
