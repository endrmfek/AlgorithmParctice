import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Node(a,b));
        }

        Collections.sort(arr, (node1, node2) -> {
            if (node1.x == node2.x) {
                return node1.y - node2.y;
            }
            return node1.x - node2.x;
        });

        StringBuilder sb = new StringBuilder();
        for (Node node : arr) {
            sb.append(node.toString()).append('\n');
        }
        System.out.println(sb);

    }

    static class Node {
        int x;
        int y;

        Node(int x,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
