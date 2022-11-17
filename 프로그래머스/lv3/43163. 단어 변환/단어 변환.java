import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
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