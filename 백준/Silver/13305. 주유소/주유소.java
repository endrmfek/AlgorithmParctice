import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] costs = new long[n];
        long[] distances = new long[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            costs[i] = Long.parseLong(st.nextToken());
        }

        long minCost = costs[0];
        long total = 0;
        
        for(int i=0; i<n-1; i++) {
            if(costs[i] < minCost) {
                minCost = costs[i];
            }
            
            total += minCost * distances[i];
        }

        System.out.println(total);

    }

}
