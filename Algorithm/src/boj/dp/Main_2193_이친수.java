package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2193_이친수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] dp_table = new long[N+1];
        
        dp_table[0] = 0;
    	dp_table[1] = 1;
    	
        for(int i=2; i<=N; i++) {
        	dp_table[i] = dp_table[i-1] + dp_table[i-2];
        }
        
        System.out.println(dp_table[N]);
	}
}
