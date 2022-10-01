package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1463_1로만들기_정혜주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp_table = new int[N+1];

		for (int i = 2; i < dp_table.length; i++) {
			dp_table[i] = dp_table[i-1]+1;
			if(i % 2 == 0){
				dp_table[i] = Math.min(dp_table[i], dp_table[i/2] + 1);
            }
            if(i % 3 == 0) {
            	dp_table[i] = Math.min(dp_table[i], dp_table[i/3] + 1);
            }
		}
		
		System.out.println(dp_table[N]);
	}
}
