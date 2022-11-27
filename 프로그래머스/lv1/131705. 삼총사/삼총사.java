import java.util.Arrays;

class Solution {
    int[] result = new int[3];
    int answer = 0;
    public int solution(int[] number) {
        //dfs져?
        dfs(0,0, number);
        return answer;
    }
    void dfs(int depth ,int index, int[] arr) {
        if(depth == 3) {
            // System.out.println(Arrays.toString(result));
            if(Arrays.stream(result).sum() == 0) {
                answer++;
            }
            return;
        }

        for(int i=index; i<arr.length; i++) {
            result[depth] = arr[i];
            dfs(depth+1 , i+1, arr);
        }
    }
}