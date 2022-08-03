package boj.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다른 방법
// 구간에서 범위가아닌 박스구간 빼고 두번 뺸 곳 다시 더해주기 - dp
// dp[2][3] = dp[2][2]+dp[1][3]-dp[1][2]


public class Main_11660_구간합구하기5_정혜주 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N]; // 인덱스 1부터 시작하기 떄문에 N+1로 넣어줘도 됨 -> 이러면 아래서에서 0일때 겨우 안 나눠도 됨
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int j=0; j<N; j++) {
				sum += Integer.parseInt(st.nextToken());
				map[i][j] = sum;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1= Integer.parseInt(st.nextToken())-1;
			int y1= Integer.parseInt(st.nextToken())-1;
			int x2= Integer.parseInt(st.nextToken())-1;
			int y2= Integer.parseInt(st.nextToken())-1;
			
			int result = 0;
			for(int j=x1; j<=x2; j++) {
				if(y1!=0) {
					result += map[j][y2] - map[j][y1-1];
				}else {
					result += map[j][y2];
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
		
	}
}
