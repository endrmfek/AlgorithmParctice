class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int leftStart = 1;

        for(int station : stations) {
            if(leftStart < station-w) {
                int leftEnd = station-w;
                int length = leftEnd - leftStart;
                int count = length / (2*w + 1);
                answer += count;
                if(length % (2 * w + 1) != 0) {
                    answer += 1;
                }
            }
            leftStart = station + w + 1;

        }

        if(stations[stations.length-1] + w < n) {
            int leftEnd = n+1;
            int length = leftEnd - leftStart;
            int count = length / (2 * w + 1);
            if(length % (w * 2 + 1) != 0) {
                count++;
            }
            answer += count;
        }

        return answer;
    }
}