package programmers.implement;

import java.util.*;

public class 개인정보수집유효기간 {
    //2021년 1월 5일 -> 2022년 1월 5일 파기
    public static List solution(String today, String[] terms, String[] privacies) {
        //모든달은 28일
        //파기해야될 개인정보의 번호를 오름차순으로
        List<Integer> answer = new ArrayList<>();
        String[] days = today.split("\\.");
        int tYear = Integer.parseInt(days[0]);
        int tMonth = Integer.parseInt(days[1]);
        int tDay = Integer.parseInt(days[2]);
        int std = (tYear*28*12) + (tMonth*28) + tDay; // 일로 통합


        Map<String, Integer> term = new HashMap<>();
        for(String t : terms) {
            String[] data = t.split(" "); // A 6
            term.put(data[0] , Integer.parseInt(data[1]));
        }
        int index = 1;
        for(String p : privacies) {
            String[] data = p.split(" ");
            String[] dayData = data[0].split("\\.");
            String termData = data[1];
            int plus = term.get(termData);

            int yy = Integer.parseInt(dayData[0]);
            int mm = Integer.parseInt(dayData[1]);
            int dd = Integer.parseInt(dayData[2]);

            if (plus >=(yy*28*12 + mm*28 + plus*28 + dd)) {
                answer.add(index);
            }
            index++;
        }
        return answer;
    }

    public static void main(String[] args) {
        solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }
}
