class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] wordList = {"aya", "ye", "woo", "ma"};
        String[] repeatWord = {"ayaaya", "yeye", "woowoo", "mama"};

        for(String bab : babbling) {
            int check = 0;
            for(String repeat : repeatWord) { // 중복검사를 해
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
}