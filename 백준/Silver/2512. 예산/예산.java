import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] data = new int[n];
        long min = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            if (data[i] > max) {
                max = data[i];
            }
        }
        int target = Integer.parseInt(br.readLine());
        long answer = 0;
        
        max++;
        while (min < max) {
            long mid = (min + max) / 2;
            long dataSum = 0;
            for(int i=0; i<n; i++) {
                if(data[i] > mid) {
                    dataSum += mid;
                } else {
                    dataSum += data[i];
                }
            }
            if( dataSum > target) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
