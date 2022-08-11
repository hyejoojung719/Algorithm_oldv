package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_구간합구하기4_정혜주 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		
		st  = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		int sum = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			sum += Integer.parseInt(st.nextToken());
			num[i] = sum ;
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			
			int result;
			if((start-1)>=0) {
				result = num[end]-num[start-1];
			}else {
				result = num[end];
			}
			
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
	}
}
