package programmers.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    //begin to target.
    //한번에 한 개의 알파벳만 바꿔.
    //words에 있는 단어로만 바꿔.
    //최소 몇단계 과정?..
    //모든 단어의 길이가 같아.
    //words엔 3~50개 단어. 중복 x
    //변환 안되면 0 return.
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        //어떻게 변환시킬거야?..

        if(Arrays.stream(words).noneMatch(a-> a.equals(target))) {
            return 0;
        }

        Queue<Check> q = new LinkedList<>();
        q.add(new Check(begin, 0));
        visited = new boolean[words.length];

        while(!q.isEmpty()) {
            Check check = q.poll();
            char[] checkWord = check.word.toCharArray();

            if(check.word.equals(target) && check.count > 0 ) {
                return check.count;
            }

            for(int i=0; i< words.length; i++) {
                if(visited[i]) {
                    continue;
                }
                String word = words[i];
                char[] wordChar = word.toCharArray();
                int matchCount = 0;
                for(int j=0; j<wordChar.length; j++) {
                    if( wordChar[j] == checkWord[j]) {
                        matchCount++;
                    }
                }
                if(matchCount == checkWord.length-1) {
                    q.add(new Check(word, check.count + 1));
                    visited[i] = true;
                }
            }
        }
        return answer;
    }

    class Check {
        String word;
        int count;

        Check(String word , int count) {
            this.word = word;
            this.count = count;
        }
    }
}
