package programmers;

public class 기지국설치 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int leftStart = 1; // 시작점

        for(int station : stations) { // station의 앞쪽을 계산

            if(leftStart < station-w) {
                int leftEnd = station-w;
                int length = leftEnd - leftStart; // 영향을 받지 않는 총 거리
                int count = length / (2*w + 1); // 거리를 (2w+1)로 나누면 -> 바로 개수 나옴.
                answer += count;
                if(length % (2 * w + 1) != 0) { // 딱 나눠떨어지지가 않는다? -> 나머지가있다..
                    answer += 1;
                }
            }
            leftStart = station + w + 1; // 오른쪽으로 이동

        }

        if(stations[stations.length-1] + w < n) { // station의 오른쪽 계산
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
