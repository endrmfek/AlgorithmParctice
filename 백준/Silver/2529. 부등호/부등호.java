import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[] data;
    static int[] num, result;
    static boolean[] visited;
    static List<String> temp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        data = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            data[i] = st.nextToken();
        }
        num = new int[] {0,1,2,3,4,5,6,7,8,9};
        visited = new boolean[10];
        result = new int[n + 1];


        //로직
        //완전탐색이 답이잖아?
        dfs(0);

        System.out.println(temp.get(temp.size()-1));
        System.out.println(temp.get(0));
    }

    public static void dfs(int depth) {
        if(depth == n+1) {
            boolean check = true;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++) {
                if (data[i].equals("<")) {
                    if (result[i] < result[i+1]) {
                        sb.append(result[i]);
                    } else {
                        check = false;
                        break;
                    }
                } else {
                    if (result[i] > result[i+1]) {
                        sb.append(result[i]);
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            if(check) {
                sb.append(result[n]);
                temp.add(sb.toString());
            }
            return;
        }
        for(int i=0; i<num.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

}
