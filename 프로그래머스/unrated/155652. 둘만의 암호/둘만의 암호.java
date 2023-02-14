import java.util.*;

class Solution {
    public static String solution(String s, String skip, int index) {
        String answer = "";
        char[] skipChars = skip.toCharArray();
        Arrays.sort(skipChars);
        int n = skipChars.length;
        List<Character> charList = new ArrayList<>();

        //초기화
        int skipIndex = 0;
        for(int i=0; i<26; i++) {
            char c = (char) ('a' + i);
            if(skipIndex < skipChars.length && skipChars[skipIndex] == c ) {
                skipIndex++;
            } else {
                charList.add((char) ('a' + i));
            }
        }


        //변환
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int originalIndex = charList.indexOf(c);
            char transform = charList.get( (originalIndex + index) % charList.size());
            sb.append(transform);
        }
        return sb.toString();
    }
}