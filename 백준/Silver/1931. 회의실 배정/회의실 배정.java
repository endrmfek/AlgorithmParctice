import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] data = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            data[i][0] = start;
            data[i][1] = end;
        }

        //로직

        //빨리 끝나는 순으로 오름차순 정렬
        Arrays.sort(data, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int prevEndTime = 0;
        int count = 0;
        for(int[] time : data) {
            int nowStartTime = time[0];
            int nowEndTime = time[1];
            if(prevEndTime <= nowStartTime) {
                count++;
                prevEndTime = nowEndTime;
            }
        }

        System.out.println(count);
    }
}
