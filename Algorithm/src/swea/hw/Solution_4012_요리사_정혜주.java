package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사_정혜주 {
	static int N;
	static int[][] arr;
	static boolean[] check;
	
	public static void comb(int cnt, int start) {
		if(cnt == N/2) {
			System.out.println(Arrays.toString(check));
			return;
		}
		
		for(int i=start; i<N; i++) {
			check[cnt] = true;
			comb(cnt+1, i+1);
			check[cnt] = false;
		}
	}


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for(int tc=1; tc <= TC; tc++ ) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];

			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
					
			check  = new boolean[N];
			comb(0,0);

			System.out.println("#"+tc + " " );
		}
	}
}
