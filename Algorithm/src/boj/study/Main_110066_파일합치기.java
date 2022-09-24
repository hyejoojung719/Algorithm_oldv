package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_110066_파일합치기 {
	public static void main(String[] args) throws Exception {
		// 파일합칠 떄 최소 비용 계산
		// 비용 = 파일 용량
		// 연속된 파일만 합칠 수 있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T  = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int k = Integer.parseInt(br.readLine());
			
			int[] files = new int[k+1];
			int[] sum = new int[k+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=k; i++) {
				files[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
		}
	}
}
