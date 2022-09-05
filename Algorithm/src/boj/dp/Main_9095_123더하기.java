package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 1, 2, 3의 합으로 나타내는 방법의 수
		int TC = Integer.parseInt(br.readLine());
		
		int[] dp_table  = new int[12];
		dp_table[1] = 1;
		dp_table[2] = 2;
		dp_table[3] = 4;
		
		for (int i = 4; i < dp_table.length; i++) {
			dp_table[i] = dp_table[i-1] + dp_table[i-2] + dp_table[i-3];
		}
		
		for(int tc=1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp_table[N]+"\n");
		}
		
		System.out.println(sb);
	}
}
