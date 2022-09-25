package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합_정혜주 {
	
	static int N,S;
	static int[] input;
	static boolean[] isSelected;
	static int cnt;
	
	private static void subSet(int index) {
		
		if(index==N) {
			int falseCnt = 0;
			for(int i=0; i<N; i++) {
				if(!isSelected[i]) falseCnt++;
			}
			if(falseCnt!=N) {
				// 즉 공집합이 아니라면!!
				int tsum=0;
				for(int i=0; i<N; i++) {
					if(isSelected[i]) {
						tsum += input[i];
					}
				}
				
				if(tsum == S) cnt++;
			}
			
			return;
		}
		isSelected[index] = true;
		subSet(index+1);
		isSelected[index] = false;
		subSet(index+1);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		input = new int[N];
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		subSet(0);
		
		System.out.println(cnt);
	}
}
