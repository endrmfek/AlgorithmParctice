package programmers;

import java.util.ArrayList;
import java.util.List;

public class 외벽점검 {

}


    /*boolean[] visited;
    int[] dist;
    int answer;
    List<Integer> workers = new ArrayList<>();

    //빠른 공사 진행을 위해 점검 시간을 1시간으로 제한했습니다
    //정북 -> 0 , 시계방향으로부터
    //외벽 길이 n 1~200
    //취약지점의 위치 = weak 길이 1~15 원소 0~n-1
    //1시간 동안 이동할 거리 1~8
    //친구수의 최소값.
    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;
        int weakLen = weak.length;
        int distLen = dist.length;
        visited = new boolean[distLen];
        answer = distLen+1;

        for(int i=0; i<weak.length; i++) {
            int[] shiftWeak = new int[weakLen];
            for(int j=0; j< weakLen-i; j++) {
                shiftWeak[j] =weak[j+i];
            }
            for(int j=weakLen-i; j<weakLen; j++) {
                shiftWeak[j] = weak[j+i-weakLen] + n;
            }

            for(int j=1; j<=distLen; j++){
                //1명부터 최대 친구까지
                dfs(0,j,shiftWeak);
                if(j >= answer) { // 이게 예술이네
                    break;
                }
            }

        }
        return answer == distLen+1 ? -1 : answer;
    }

    void dfs(int depth, int maxDepth, int[] weak) {
        //순열 완성되었을때 고칠 수 이썽?
        if(depth == maxDepth) {
            if(canFix(weak)) {
                answer = Math.min(answer, depth);
            }
            return;
        }
        //배열 안에서 조합찾아야돼.
        for(int i=0; i<dist.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            workers.add(i);
            dfs(depth+1 , maxDepth, weak);
            workers.remove(workers.size()-1);
            visited[i] = false;
        }
    }

    boolean canFix(int[] weak) {
        int index = -1; //그 다음부터 시작할거니까?
        for(int worker : workers) {
            int d = weak[index + 1] + dist[worker];
            for(int i=index+1; i<weak.length; i++) {
                if(weak[i] <= d) {
                    index = i;
                } else {
                    break;
                }
            }
        }
        return true;
    }*/
