import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];
        Bag[] bags = new Bag[k];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<k; i++) {
            bags[i] = new Bag(Integer.parseInt(br.readLine()));
        }

        //보석 몇개 넣을 수 있는지 (k), 가방에 담을 수 있는 최대 무게,
        //보석의 최대 가격.
        //무게순으로 정렬하되 무게가 같으면 가격이 비싼거.
        Arrays.sort(jewels, (o1,o2) -> {
            if(o1.weight == o2.weight) {
                return o2.price - o1.price;
            }
            return o1.weight - o2.weight;
        });
        //가방은 일단 가벼운 순으로?
        Arrays.sort(bags, (o1,o2)-> {
            return o1.weight - o2.weight;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //가방마다 돌아봐.
        int jewelsIndex = 0;
        long result = 0;
        for(int i=0; i<k; i++) {

            //가방과 주얼 모두 가벼운 순으로 넣었다.
            //주얼이 무거워지는 순간 반복문은 끝나고 가방 무게에 넣을 수 있는 주얼 중 가장 비싼 주얼을 계산한다
            //다음 가방은 이전 주얼들을 무조건 수용가능하다 (무게에 따른 오름차순이니) 그러므로 이전 주얼을 확인 할 필요가 없다.
            while(jewelsIndex < n && jewels[jewelsIndex].weight <= bags[i].weight) {
                pq.offer(jewels[jewelsIndex].price);
                jewelsIndex++;
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }

    static class Bag {
        int weight;
        Bag(int w) {
            this.weight = w;
        }
    }
    static class Jewel {
        int weight;
        int price;

        Jewel(int w, int p) {
            this.weight = w;
            this.price = p;
        }
    }

}
