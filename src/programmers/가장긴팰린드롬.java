package programmers;

public class 가장긴팰린드롬 {

    public int solution(String s) {
        char[] chars = s.toCharArray();
        for(int i=s.length(); i>0; i--) {
            for(int j=0; j+i <= s.length(); j++) {
                if(check(j, j+i-1, chars)) return i; // index이기 때문에 -1. ex) length 7 -> 마지막 인덱스 6.
            }
        }
        return 0;
    }
    boolean check(int start, int end, char[] data) {
        while(start <= end) {
            if(data[start++] != data[end--]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        가장긴팰린드롬 a = new 가장긴팰린드롬();
        System.out.println(a.solution("abacde"));
    }
}
