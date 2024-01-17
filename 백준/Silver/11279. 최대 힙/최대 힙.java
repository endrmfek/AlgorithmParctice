import java.io.*;
import java.util.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> {
            return -(o1-o2);
        });
        for(int i=0; i<n; i++) {
            int data = Integer.parseInt(br.readLine());
            
            if(data == 0) {
                if(!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                q.offer(data);
            }
            
        }
        
    }

}
