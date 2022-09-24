package boj.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_로또2 {
	static int[] lottoNum;
	static int N;
	static int[] selected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			if(N==0) break;
			
			lottoNum = new int[N];
			
			for(int i=0; i<N; i++) {
				lottoNum[i] = Integer.parseInt(st.nextToken());
			}
			
			selected = new int[6];
			comb(0,0);
			System.out.println(sb);
		}
	}
	
	private static void comb(int cnt, int start) {
		
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[cnt] = lottoNum[i];
			comb(cnt+1, i+1);
		}
	}
}
