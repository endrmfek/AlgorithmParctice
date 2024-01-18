import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)-> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1-o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if(!heap.isEmpty()) {
                    System.out.println(heap.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                heap.offer(input);
            }
        }

    }

}
