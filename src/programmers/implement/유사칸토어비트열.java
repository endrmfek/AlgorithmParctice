package programmers.implement;

public class 유사칸토어비트열 {
    // n번째 -> n-1에서 1을 11011로 치환 , 0을 00000로 치환.
    //특정 구간 내에 1의 개수.
    //무조건 재귀로 풀어야돼.


    public int solution(int n, long l, long r) {
        // n은 1부터 시작해.
        int answer = 0;
        String data = "11011";

        if( n == 1) {
//            answer = data.substring(l-1 , r);
        }

        recursion(n);

        return answer;
    }

    private void recursion(int n) {

        for(int i=0; i<n; i++) {
            recursion(n);
        }
    }


    // n = 0 -> 1

    // n = 1 -> 11011 -> 5

    // n = 2 -> 11011 11011 00000 11011 11011 5 * 5
    // n = 3 -> 11011 11011 00000 11011 11011
    //          11011 11011 00000 11011 11011
    //          00000 00000 00000 00000 00000
    //          11011 11011 00000 11011 11011
    //          11011 11011 00000 11011 11011
}
