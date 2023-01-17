package programmers.implement;

import java.util.ArrayList;
import java.util.List;

public class n진수게임 {
    //둥글게 앉아서.
    public static String solution(int n, int t, int m, int p) {
        //n = 진법 , 2
        //t = 미리 구할 숫자의 개ㅜ수 , 4
        //m = 게임에 참가하는 인원 , 2
        //p = 튜브의 순서 , 1
        //-> 0111
        //0, 1 ,1 0, 1 1, 1 0 0, 1 0 1,
        //0 1 2 3 4
        StringBuilder sb = new StringBuilder();
        char[] answer = new char[t];
        //몇까지 세어야돼?
        //1. 10진수 ->n 진수로 변환
        for(int i=0; i<t*m; i++) {
            String s = Integer.toString(i, n);

            sb.append(s.toUpperCase());
        }

        //2. 원으로 꼬여있다고?
        int index = 0;
        for(int i=0; i<sb.length(); i++) {

            //인원과 순서가 중요해.
            if (i == p-1) {
                //처리하고
                answer[index] = sb.charAt(i);
                p += m;
                index++;

                if(index == answer.length) {
                    break;
                }
            }
        }
        return new String(answer);
    }

    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 2));
    }
}
