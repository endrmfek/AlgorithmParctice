import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] data = new int[n];
        st = new StringTokenizer(br.readLine());

        int min = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, data[i]);
        }

        //로직
        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int tree : data) {
                if(tree >= mid) {
                    sum += (tree-mid);
                }
            }
            if(sum < m) {
                max = mid;
            } else { //sum >= m
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }



}
