package boj.stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main6198 {
	public static void main(String[] args) throws Exception{
		// 각 관리인들이 벤치마킹 가능한 빌딩 수의 합 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] building = new int[N];
		for(int i=0; i<N; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		
		
	}
}
