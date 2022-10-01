package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17070_파이프옮기기1_정혜주 {
	
	static int[][] deltas = {{0,1},{1,0},{1,1}};	// 우 하 우하향
	static int N;
	static int[][] map;
	
	
	public static void main(String[] args) throws Exception {
		
		// N+1 * N+1 배열 만들기
		// 파이프는 두개의 연속된 칸 차지하며 빈 칸만 차지 가능
		// 가능한 회전 방향 : 가로, 세로, 우하향
		// 이동 방향 : 우, 우하향, 하
		
		// 꼭 빈 칸이어야 하는 곳은 색으로 표시
		
		// 초기 파이프는 (1,1), (1,2) 차지 
		// 파이프의 한쪽 끝을 (n,n)으로 이동시키는 방법의 수?
		// 없으면 0 출력
		
		// solution
		// 1. 현재 상태가 가로, 세로, 대각선으로 놓여있는지 판단해야함(끝점 기준)
		//		if 가로
		//			- 우 
		//			- 우하
		//		if 세로
		//			- 하
		//			- 우하
		//		if 대각선
		//			- 우
		//			- 하
		//			- 우하
		// 2. 단, 벽에 닿으면 안되므로 이동하려는 방향과 이동하려는 곳이
		//		- 우 & 끝점이 N에 위치 OR 벽에 위치 할 경우 X
		// 		- 그 위에는 경계 체크, 벽 체크
		// 3. 역으로 생각
		//		if 세로로 놓고 싶다면
		//		- 이전에는 세로 또는 대각선 파이프
		//      if 가로로 놓고 싶다면
		//		- 이전에는 가로 또는 대각선 파이프
		//		if 대각선으로 놓고 싶다면
		//		- 이전에는 가로, 세로, 대각선 파이프
		//		동시에 경계 체크 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] dp = new int[N][N][3];	// -> 올수 있는 경우의 수
		
		// 초기값
		dp[0][1][0]=1;
		
		for (int i = 0; i <N; i++) {
			for (int j = 2; j < N; j++) {	
				
				// 가로
				if(map[i][j]!=1) dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				
				// 세로
				if(i-1>=0 && map[i][j]!=1) dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				
				// 대각선
				if(i-1>=0 && map[i][j]!=1 && map[i-1][j]!=1 && map[i][j-1]!=1) dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				
			}
		}
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
		
	
	}
}
