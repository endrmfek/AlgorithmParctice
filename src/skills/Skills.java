package skills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Skills {
	class Combination {  // 조합 코드
		private int n;
		private int r;
		private int[] now; //지금 조합
		private ArrayList<ArrayList<Integer>> result; // 모든 조합
		
		public ArrayList<ArrayList<Integer>> getResult() {
			return result;
		}
		
		public Combination(int n, int r) {
	        this.n = n;
	        this.r = r;
	        this.now = new int[r];
	        this.result = new ArrayList<ArrayList<Integer>>();
	    }
		
		public void combination(ArrayList<Integer> arr, int depth, int index, int target) {
			if(depth == r) {
				ArrayList<Integer> temp = new ArrayList<>();
				for(int i=0; i<now.length; i++) {
					temp.add(arr.get(now[i]));
				}
				result.add(temp);
				return;
			}
			
			if(target == n) return ;
			now[index] = target;
			combination(arr, depth+1, index+1, target+1);
			combination(arr, depth, index, target+1);
		}
	}
	
	class Permutation { //nPr
		private int n;
		private int r;
		private int[] now;
		private ArrayList<ArrayList<Integer>> result;
		
		public ArrayList<ArrayList<Integer>> getResult() {
			return result;
		}
		
		public Permutation(int n, int r) {
			this.n = n;
			this.r = r;
			this.now = new int[r];
			this.result = new ArrayList<ArrayList<Integer>>();
		}
		
		public void swap(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		public void permutation(int[] arr, int depth) {
			if(depth == r) {
				ArrayList<Integer> temp = new ArrayList<>();
				for(int i=0; i<now.length; i++) {
					temp.add(now[i]);
				}
				result.add(temp);
				return;
			}
			
			for(int i=depth; i<n; i++) {
				swap(arr, i, depth);
				now[depth] = arr[depth];
				permutation(arr, depth+1);
				swap(arr, i, depth);
			}
		}
		
		
 	}
	
	public void permutation(String prefix, String str, HashSet<Integer> set) { // 모든 경우의 수.
		int n = str.length();
		//if(n==0) System.out.println(prefix);
		if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
		for(int i=0; i<n; i++) {
			permutation(prefix+str.charAt(i), str.substring(0,i) + str.substring(i+1, n), set);
		}
	}
	
	
	public ArrayList<Integer> divisor (int n) { //약수구하기
		int sqrt = (int) Math.sqrt(n);
		ArrayList<Integer> divisor = new ArrayList<>();
		for(int i=1; i<=sqrt; i++) {
			if(n%i == 0) {
				divisor.add(i);
				if(n/i != i) {
					divisor.add(n/i);
				}
			}
		}
		divisor.sort(Comparator.naturalOrder());
		return divisor;
	}
	
	//시간 계산하기
	public int cal_time(String time){
        String[] temp= time.split(":");
        int hour= Integer.parseInt(temp[0])*60;
        int min= Integer.parseInt(temp[1]);       
        return hour+min;
    }

	public int[] makeCounter(String[] arr) {
		//Counter 만들기.
		// ["red" , "blue", "red", "green" , "blue"] -> {red : 2 , blue : 2, green : 1}
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> counter = new LinkedHashMap<>();

		for (String i : arr) {
			counter.put(i, counter.getOrDefault(i, 0) + 1);
		}

		List<Entry<String, Integer>> list = new ArrayList<>(counter.entrySet()); //여기가 중요.

		//값에 대해 내림차순 정렬
		Collections.sort(list, (a,b) -> {
			return b.getValue().compareTo(a.getValue()); //내림차순
		});

		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			answer.add(Integer.parseInt(entry.getKey()));
		}
		return answer.stream().mapToInt(i->i).toArray();

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1000;
		
		
		// 행과 열을 한 단어로 줄때 숫자 or 영어로 변환 어떻게 할거야?
		String data1 = sc.nextLine(); // 일단 String으로 데이터를 받은 후 ex) a1
		int row = data1.charAt(0) - 'a' + 1;   // 문자 a의 아스키값이 만약 29라면 문자 a의 아스키값 29을 빼서 1로 만듬.
		int column = data1.charAt(1) - '0';    // 1
		
		
		//문자 판별하기
		Character.isLetter(data1.charAt(0));
		
		//int[]배열을 리스트로.
		int[] numbers = new int[n + 1];
		ArrayList<Integer> a =(ArrayList<Integer>) Arrays.stream(numbers).boxed().collect(Collectors.toList());

		
		//List를 int[]배열로
		List<Integer> answer = new ArrayList<>();
		int[] answerToIntArr = answer.stream().mapToInt(Integer::intValue).toArray();

		
		//String을 int[]배열로 "12345" -> [1,2,3,4,5];
		String stringNumber = "12345";
		int[] stringToNumArr = Stream.of(stringNumber.split("")).mapToInt(Integer::parseInt).toArray();

		
		//List<Integer>를 정수로

		List<Integer> arr = Arrays.asList(new Integer[]{1,2,3});
		String num = arr.stream().map(String::valueOf).collect(Collectors.joining());
		int number = Integer.valueOf(num);



		
		//정렬 기준 바꾸기
		List<int[]> answerList = new ArrayList<>();
    	answerList.sort(new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				for (int i = 10; i >= 0; i--) {
					if (o1[i] != o2[i]) {
						return o2[i] - o1[i];
					}
				}
				return 0;
			}
		});

	}
}
