import java.util.Arrays;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer =0;
        int num = Arrays.stream(picks).sum();
        int[][] section = new int[minerals.length / 5 + 1][3];

        for(int i=0; i<minerals.length && num > 0; i++ ) {
            switch (minerals[i].charAt(0)) {
                case 'd':
                    section[i/5][0] += 1;
                    section[i/5][1] += 5;
                    section[i/5][2] += 25;
                    break;
                case 'i':
                    section[i/5][0] += 1;
                    section[i/5][1] += 1;
                    section[i/5][2] += 5;
                    break;
                case 's':
                    section[i/5][0] += 1;
                    section[i/5][1] += 1;
                    section[i/5][2] += 1;
            }
            if(i%5 == 4) num--;
        }
        
        Arrays.sort(section, (o1, o2) -> {
            if(o1[2] <o2[2]) return 1;
            else return -1;
        });
        int i=0, pick=0;
        for(i =0, pick=0; i<section.length; i++) {
            while(pick < 3 && picks[pick] == 0) pick++;
            if(pick == 3) break;
            picks[pick]--;
            answer += section[i][pick];
        }
        return answer;
        
    }
}