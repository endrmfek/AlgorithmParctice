import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력부
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();

        //구현부
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (maxQ.size() == minQ.size()) {
                maxQ.add(input);
                if (!minQ.isEmpty() && maxQ.peek() > minQ.peek()) {
                    minQ.add(maxQ.poll());
                    maxQ.add(minQ.poll());
                }
            } else {
                minQ.add(input);
                if (maxQ.peek() > minQ.peek()) {
                    minQ.add(maxQ.poll());
                    maxQ.add(minQ.poll());
                }
            }
            sb.append(maxQ.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }

}
