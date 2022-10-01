package etc.dp;

import java.util.Scanner;

public class 연습문제1_아파트만들기_sol2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] dp = new int[N+1][2];
		// [?][0] : 최하단 노란색
		// [?][1] : 최하단 파란색
		
		// 초기값 셋팅
		dp[1][0]=1;
		dp[1][1]=1;
		
		for (int i = 2; i <=N; i++) {
			// i층을 칠할 때 최하단을 노란색으로 칠할 때 경우의 수
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			
			// i층을 칠할 때 최하단을 파란색으로 칠할 때 경우의 수
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(dp[N][0]+dp[N][1]);
	}
}
