package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리_정혜주 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// N개의 집이 있을 때
		// 규칙을 만족하는 모든 집을 칠하는 비용의 최솟값?
		// 1. 1번 집의 색 != 2번 집의 색
		// 2. N번 집의 색 != N-1번 집의 색
		// 3. i번(2<= i <=N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 X ==> 연속해서 같은 색 X

		// Solution

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3]; // 0 : R, 1 : G, 3 : B

		// 집의 수 만큼
		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// R을 칠할고 싶을때
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
			
			// G를 칠할고 싶을때
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
			
			// B를 칠할고 싶을때
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B;
			
		}
		
		Arrays.sort(dp[N]);
		System.out.println(dp[N][0]);


	}
}
