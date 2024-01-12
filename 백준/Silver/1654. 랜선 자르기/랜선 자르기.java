import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1<= n <=1,000,000
        int k = Integer.parseInt(st.nextToken());
        int[] lans = new int[n];
        long start = 0;
        long end = 0;
        for (int i = 0; i < n; i++) {
            lans[i] = Integer.parseInt(br.readLine()); //lan <= 2^31 -1
            end = Math.max(end, lans[i]);
        }

        //로직
        end++;
        while(start < end) {
            long mid = (start + end) / 2;
            long target = 0;
            for (int i = 0; i < n; i++) {
                target += lans[i] / mid;
            }

            //부족한 경우 -> 값을 줄여야돼.
            if(target < k) {
                end = mid;
            } else { //k와 같거나 작은 경우 -> 최대값을 구해야되니까
                //k값을 도전해도 start가 +1 되면서 end를 넘어가게 될거야.
                start = mid + 1;
            }
        }

        System.out.println(start - 1);

    }
    
}
