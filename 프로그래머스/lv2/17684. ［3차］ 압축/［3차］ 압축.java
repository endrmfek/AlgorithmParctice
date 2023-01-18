import java.util.*;
class Solution {
    //1. 사전 초기화
    //2. 가장 긴 문자열 w 찾어
    //3. w에 해당하는 사전의 색인번호 출력, 입력에서 w제거
    //4. 다음글자(c) 있으면 w+c에 해당하는 단어를 사전에 등록.
    //5. 단계 2
    public static int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();

        for(int i=0; i<26; i++){
            dict.put(String.valueOf((char) ('A'+i)), i+1);
        }
        int index = 27;

        //KAKAO
        for(int i=0; i<msg.length(); i++) {

            int msgIndex = i;
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i)); // K
            int temp = msgIndex;

            while(dict.containsKey(sb.toString()) && ++msgIndex < msg.length()) {
                --msgIndex;
                sb.append(msg.charAt(++msgIndex)); // KA -> X
            }

            answer.add(dict.get(msg.substring(i,msgIndex)));
            dict.put(sb.toString() , index++);

            i=msgIndex-1;
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


}