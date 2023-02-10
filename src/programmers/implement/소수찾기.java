package programmers.implement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class 소수찾기 {

    static List<String> data = new ArrayList<>();

    public static int solution(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();

        //length별 모든 순열 구해
        for(int i=1; i<= arr.length; i++) {
            List<Integer> indexList = new ArrayList<>();
            boolean[] visited = new boolean[arr.length];
            dfs(0, arr, i, indexList, visited);
        }

        //중복 제거
        List<Integer> collect = data.stream().mapToInt(Integer::valueOf).distinct().boxed().collect(Collectors.toList());
        for(int i=0; i<collect.size(); i++) {
            int number = collect.get(i);
            System.out.println(number);
            if(isPrime(number) ) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(int number) {
        if(number == 1 || number == 0) {
            return false;
        }
        if(number == 2) {
            return true;
        }
        for(int i=2; i<Math.sqrt(number) + 1; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }


    private static void dfs(int depth, char[] arr, int length, List<Integer> list, boolean[] visited) {
        if(depth == length) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<list.size(); i++) {
                sb.append(arr[list.get(i)]);
            }
            data.add(sb.toString());
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                list.add(i);
                visited[i] = true;
                dfs(depth+1, arr, length, list, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

    private void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for(int i=0; i<n; i++) {
            permutation(prefix+str, str.substring(0,i)+str.substring(i+1,n), set);
        }
    }

    public int solution1(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);

        while(set.iterator().hasNext()) {
            Integer a = set.iterator().next();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}
