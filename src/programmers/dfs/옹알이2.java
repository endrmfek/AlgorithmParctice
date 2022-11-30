package programmers.dfs;

import java.util.*;

public class 옹알이2 {

    public int solution(String[] babbling) {
        int answer = 0;
        String[] wordList = {"aya", "ye", "woo", "ma"};
        String[] repeatWord = {"ayaaya", "yeye", "woowoo", "mama"};

        for(String bab : babbling) {
            int check = 0;
            for(String repeat : repeatWord) {
                if (bab.contains(repeat)) {
                    bab = bab.replace(repeat , "F");
                }
            }
            for(String word : wordList) {
                if (bab.contains(word)) { // 이거 포함하면
                    bab = bab.replace(word, "T");
                }
            }

            for(int i=0; i<bab.length(); i++) {
                if(bab.charAt(i) == 'F') {
                    check = 1;
                    break;
                }
                if(bab.charAt(i) != 'T') {
                    check = 1;
                    break;
                }
            }
            if(check == 0) {
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        옹알이2 a = new 옹알이2();
        a.solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
    }
}
