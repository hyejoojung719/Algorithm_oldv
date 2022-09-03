package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_2n타일링 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] dp_table  = new long[1001];
		
		// n-1타일에 세로 타일 + n-2타일에 가로타일인 경우 두 가지로 묶을 수 있다 
//		dp_table[N] = dp_table[N-1] + dp_table[N-2];
		
		// 초기값
		dp_table[1] = 1;
		dp_table[2] = 2;
		for(int i=3; i<=N; i++) {
			dp_table[i] = (dp_table[i-1] + dp_table[i-2])%10007;
			// 오버플로우 방지
		}
		
		System.out.println(dp_table[N]);
	}
}
