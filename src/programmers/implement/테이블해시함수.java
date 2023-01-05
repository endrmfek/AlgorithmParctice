package programmers.implement;

import java.util.Arrays;

public class 테이블해시함수 {

    //col번쨰 컬럼의 값을 기준으로 오름차순 정렬
    //동일하면 기본키인 첫번쨰 컬럼의 값으로 내림차순
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        //1. 정렬기준
        Arrays.sort(data, ((o1, o2) -> {
            if(o1[col-1] == o2[col-1]) {
                return o2[0] - o1[0];
            }
            return o1[col-1] - o2[col-1];
        }));
        //Arrays.sort(data,(o1, o2) -> o1[col-1]!=o2[col-1] ?o1[col-1]-o2[col-1] :o2[0]-o1[0]);

        Arrays.stream(data).forEach(i-> System.out.println(Arrays.toString(i)));
        //S_i = i번째행의 튜플에 대해 각 칼럼의 값을 i로 나눈 나머지들의 합
        int xor = 0;
        for(int i=row_begin; i<=row_end; i++) {
            int sum = 0;
            for(int j=0; j<data[i-1].length; j++) {
//                System.out.print(data[i-1][j] + " ");
                sum += data[i-1][j] % i;
            }
//            System.out.println(sum);
            xor = xor ^ sum;
        }
        return xor;
    }

    public static void main(String[] args) {
        테이블해시함수 a = new 테이블해시함수();
        System.out.println(a.solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}}, 2,2,3));
    }
}
