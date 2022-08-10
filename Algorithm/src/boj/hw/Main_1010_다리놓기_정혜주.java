package boj.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기_정혜주 {	
	
	static int left, right;
	static int cnt;
	static boolean[] isSelected;
	
	public static void connection_cnt(int start, int left, int right) {
		
		if(start > left) return;
		
		
		for(int i=start; i <=right-(left-start);i++) {
			if(isSelected[start]) continue;
			isSelected[start] = true;
			connection_cnt(i+1, left, right);
			cnt++;
			isSelected[start] = false;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
	
		// 다리 겹치면 안 됨
		for(int tc=0; tc<TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			left= Integer.parseInt(st.nextToken());
			right= Integer.parseInt(st.nextToken());
			
			isSelected = new boolean[right+1];
			
			cnt=0;
			connection_cnt(1, left, right);
			System.out.println(cnt);
		}
		
	}
}
