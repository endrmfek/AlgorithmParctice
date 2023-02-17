import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        //카메라가 최소 몇대 필요하냐..
        int answer = 0;
        //나가는 순서대로
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        //-30000 ~ 30000의 범위
        int camera = -30001;

        for(int[] route : routes) {
            //진입할때 카메라가 작으면 안찍힘.
            if(camera < route[0]) {
                answer++;
                camera = route[1];
            }
        }
        return answer;
    }
}