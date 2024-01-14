import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
    
        int[] house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        
        int start = 1; // 거리의 최소값
        int end = house[n-1] - house[0] + 1; //첫집에서 마지막집 차이

        while (start < end) {
            int mid = (start + end) / 2;
            if(isPossible(mid, house) < c) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        System.out.println(start -1);
    }
    
    private static int isPossible(int dist, int[] house) {
        //첫번째 집
        int count = 1;
        int lastInstalled = house[0];
        
        for(int i=1; i< house.length; i++) {
            int now = house[i];
            
            if(now - lastInstalled >= dist) {
                count++;
                lastInstalled = now;
            }
        }
        return count;
    }
}
