package boj.순열과조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10974_모든순열 {
	
	static int N;
	static boolean[] isSelected;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	private static void perm(int cnt) {
		if(cnt==N) {
			for (int i = 1; i <= N; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(isSelected[i])continue;
			isSelected[i] = true;
			result[cnt+1] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		
		isSelected = new boolean[N+1];
		result = new int[N+1];
		perm(0);
		System.out.println(sb);
	}
}
