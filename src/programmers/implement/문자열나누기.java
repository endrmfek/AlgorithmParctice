package programmers.implement;

public class 문자열나누기 {
    //첫글자 x
    //왼쪽에서 오른쪽 -> x와 x가 아닌 다른 글자 각각 세
    //처음으로 두 횟수가 같아지는 순간 멈추고 지금까지 읽은 문자열 분리
    //s에서 분리한 문자열빼고
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        char x = chars[0];
        char y = 'a';
        int xCount = 1;
        int yCount = 0;
        boolean first = false;
        for(int i=1; i<n; i++) {
            y = chars[i];
            if(x == chars[i]) xCount++;
            else yCount++;

            if(xCount == yCount) {
                first = true;
                if(i+1 < n) {
                    x = chars[i+1];
                    xCount = 1;
                    yCount = 0;
                    answer++;
                    i++;
                }
            }
        }
        answer++;
        return answer;
    }
}
