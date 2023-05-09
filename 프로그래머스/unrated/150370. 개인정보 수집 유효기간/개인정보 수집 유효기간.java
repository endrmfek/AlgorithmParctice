import java.util.*;
class Solution {
    //2021년 1월 5일 -> 2022년 1월 5일 파기
    public static List solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[] todays = today.split("\\.");
        String YY = todays[0];
        String MM = todays[1];
        String DD = todays[2];
        int totalDate = Integer.parseInt(YY)*28*12 + Integer.parseInt(MM)*28 + Integer.parseInt(DD);
        //System.out.println(totalDate);

        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] data = term.split(" ");
            map.put(data[0], Integer.parseInt(data[1])*28);
        }

        for(int i=0; i< privacies.length; i++) {
            String[] privacyData = privacies[i].split(" ");
            String[] privacy = privacyData[0].split("\\.");
            int expire = map.get(privacyData[1]);
            String pYY = privacy[0];
            String pMM = privacy[1];
            String pDD = privacy[2];
            int pDate = Integer.parseInt(pYY)*28*12 + Integer.parseInt(pMM)*28 + Integer.parseInt(pDD) + expire - 1;
            //System.out.println(pDate);

            if(pDate < totalDate) {
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}