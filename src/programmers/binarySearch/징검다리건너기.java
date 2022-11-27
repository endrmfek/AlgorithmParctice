package programmers.binarySearch;

public class 징검다리건너기 {
    //1씩 줄어들어?
    //0이 되면 못가고 그 다음 디딤돌로 갈수있어.
    //그 다음 디딤돌이 여러개면 제일 가까운곳만 갈수있어.
    //친구들수 무제한?
    //전형적인 이진탐색.
    //배열크기 1~20만
    //원소값 1~2억.
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;

        //친구 수 탐색 시작.
        while(left <= right) {

            //최적 친구
            int mid = left + (right - left) / 2;

            //mid가 최적 친구라면 징검다리 건널 수 있냐?
            if(check(stones, mid, k)) {
                //갈 수 있으면 더 갈 수 있나 검사해봐.
                left = mid + 1;
                answer = mid;
            } else {
                //갈 수 없으면 친구 수 좀 줄여라.
                right = mid -1;
            }
        }
        return answer;
    }

    boolean check(int[] stones , long friend , int k) {
        int nope = 0;
        for(int stone : stones) {

            //음수되면 갈 수 없어.
            if(stone - friend < 0) {
                nope++;
            } else {
                // 음수 아니면 갈수 있어.
                nope = 0;
            }
            if(nope == k) return false;
        }

        return true;
    }
}
