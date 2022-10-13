package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합_정혜주 {
	
	static final long MOD = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 자연수 n r
		// nCr의 값을 1234567891로 나눈 나머지 출력
		// 페르마의 소정리 이용 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
		
			long fact[] = new long[n+1];
			fact[0] = 1;
			
			for(int i=1; i<=n; i++) {
				fact[i] = (fact[i-1]*i) % MOD;
			}
			
			long top = fact[n];
			long bottom = pow((fact[r]*fact[n-r])%MOD, MOD-2);
			
			sb.append("#"+tc+" "+ ((top*bottom)%MOD)+"\n");
		}
		System.out.println(sb);
	}
	
	private static long pow(long base, long exp) {
		if(exp==0) return 1;
		if(exp==1) return base;
	
		
		if(exp%2==0) {
			long a = pow(base, exp/2);
			return a*a%MOD;
		}
		
		long a = pow(base, exp-1)%MOD;
		return (a*base)%MOD;
	}
}
