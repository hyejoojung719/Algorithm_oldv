package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호_정혜주 {
	
	
	public static void passwordCheck(char ch, int[] temp) {
		temp[ch-65]--;
	}
	
	public static boolean cntCheck(int[] temp) {
		for(int n : temp) {
			if(n > 0) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] cnt = new int[26];
		
		cnt['A'-65] = Integer.parseInt(st.nextToken());
		cnt['C'-65] = Integer.parseInt(st.nextToken());
		cnt['G'-65] = Integer.parseInt(st.nextToken());
		cnt['T'-65] = Integer.parseInt(st.nextToken());
		
		int result = 0;
		for(int i=0; i<=s-p; i++) {
			
			int[] temp = Arrays.copyOf(cnt, cnt.length);
			
			for(int j=i; j<i+p; j++) {
				passwordCheck(str.charAt(j), temp);
			}
			
			if(cntCheck(temp)) result++;
		}
		
		System.out.println(result);
		
	}
}
