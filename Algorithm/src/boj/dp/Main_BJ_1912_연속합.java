package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1912_연속합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] dp = new int[N+1];	// dp[i] : i번째까지 1~i개 더한 것 중 최대값
		
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 초기화
		
		dp[0]=Integer.MIN_VALUE;
		dp[1]=arr[1];
		
		for (int i = 2; i <= N; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		
		Arrays.sort(dp);
		System.out.println(dp[N]);
		
	}
}
