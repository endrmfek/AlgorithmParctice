package programmers.dfs;

import java.util.*;

public class 옹알이2 {
    boolean[] visited = new boolean[4];
    Set<String> set;
    public int solution2(String[] babbling) {
        int answer = 0;
        String[] babble = {"aya", "ye", "woo", "ma"}; //이정도 할수있걷느여

        set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });


        for(int i=1; i<=4; i++) {
            //단어를 1개부터 4개까지쓰는 부분순열? 을 만들어야됨.
            dfs(0, i , babble, new ArrayList<>());
        }

        for(String b : babbling) {
            //이 순열안에 포함되어있니?
            if(set.contains(b)) {
                answer++;
            }
        }
        return answer;
    }
    void dfs(int depth, int n , String[] arr, ArrayList<String> words) {
        if(depth == n) {
            StringBuilder sb = new StringBuilder();
            if(words.size() == 1) {
                for(String word : words) {
                    sb.append(word);
                }
            }
            else {
                for(int i=0; i<words.size()-1; i++) {
                    sb.append(words.get(i));
                    if(words.get(i).equals(words.get(i+1))) { // 걍 중복되면 쳐넣지마
                        return;
                    }
                }
                sb.append(words.get(words.size()-1));
            }
            set.add(sb.toString());
            return;
        }

        for(int i=0; i<4; i++) { //양쪽중복을 제거하려면?
                words.add(arr[i]);
                dfs(depth+1 , n, arr, words);
                words.remove(words.size()-1);
        }
    }

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
        a.solution2(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
    }
}
