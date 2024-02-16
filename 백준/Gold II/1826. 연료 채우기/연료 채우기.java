import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //갈 수 있는 거리의 주유소 중에서 가장 연료의 양이 많은 주유소를 들러야함.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<OilStation> stations = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int fuel = Integer.parseInt(st.nextToken());
            stations.add(new OilStation(dist, fuel));
        }
        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken()); //마을까지 거리
        int P = Integer.parseInt(st.nextToken()); //기존 연료의 양

        int answer = 0;
        while(P < L) {
            //
            while(!stations.isEmpty() && stations.peek().distance <= P) {
                fuels.add(stations.poll().fuel);
            }

            if(fuels.isEmpty()) {
                System.out.println(-1);
                return;
            }

            answer++;
            P += fuels.poll();

        }

        System.out.println(answer);
    }

    static class OilStation implements Comparable<OilStation> {
        int distance;
        int fuel;

        public OilStation(int d, int f) {
            distance = d;
            fuel = f;
        }

        @Override
        public int compareTo(OilStation o) {
            return this.distance - o.distance;
        }
    }

}
