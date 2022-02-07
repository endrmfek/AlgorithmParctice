package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//안테나로부터 모든 집까지 거리의 총 합이 최소가 되도록.
//집이 위치한 곳에만 설치 가능
//동일한 위치에 여러 개의 집이 존재 가능.

public class Antenna {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		ArrayList<Integer> data = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			data.add(sc.nextInt());
		}
		
		Collections.sort(data);
		
		System.out.println(data.get((n - 1) / 2));
	}
}
