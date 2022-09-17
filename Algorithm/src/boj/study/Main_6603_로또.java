package boj.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	static int[] lottoNum;
	static int N;
	static boolean[] selected;
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
			
			selected = new boolean[N];
			comb(0,0);
			System.out.println(sb);
		}
	}
	
	private static void comb(int cnt, int start) {
		
		if(cnt == 6) {
			for(int i=0; i<N; i++) {
				if(selected[i]) {
					sb.append(lottoNum[i] + " ");
				}
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[i] = true;
			comb(cnt+1, i+1);
			selected[i] = false;
		}
	}
}
