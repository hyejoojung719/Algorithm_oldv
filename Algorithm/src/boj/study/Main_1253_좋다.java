package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1253_좋다 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 기준 숫자의 절반값을 기준으로 나눈다.
		
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		int idx=0;
		while(true) {
			for(int i=0; i<N; i++) {
				if(num[i] < num[idx]/2) {
					left.add(num[i]);
				}else if(num[i] < num[idx]){
					right.add(num[i]);
				}
			}
		}
	}
}	
