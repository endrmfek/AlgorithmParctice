import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Long> cards = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            cards.add(Long.parseLong(br.readLine()));
        }
        Long result = 0L;
        //구현부
        // 10 20 40 100 -> 가장 큰거랑 가장 작은거랑 합쳐나가는게 제일 좋을거같다.
        //어떻게 구현할래? -> deque?
        while(cards.size() != 1) {
            Long value1 = cards.poll();
            Long value2 = cards.poll();
            result += value1 + value2;
            cards.add(value1 + value2);
        }

        System.out.println(result);

    }

}
