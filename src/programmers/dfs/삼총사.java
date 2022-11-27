package programmers.dfs;

import java.util.Arrays;

public class 삼총사 {
    int[] result = new int[3];
    int answer = 0;
    public int solution(int[] number) {
        //dfs져?
        dfs(0,0, number);
        return answer;
    }

    //조합합
   void dfs(int depth ,int index, int[] arr) {
        if(depth == 3) {
            System.out.println(Arrays.toString(result));
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

    public static void main(String[] args) {
        삼총사 a = new 삼총사();
        System.out.println(a.solution(new int[] {-2,3,0,2,-5}));
    }
}
