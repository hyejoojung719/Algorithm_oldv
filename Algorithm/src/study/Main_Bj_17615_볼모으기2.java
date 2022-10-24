package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_Bj_17615_볼모으기2 {
	public static void main(String[] args) throws Exception {
		// 같은 색 끼리 인접하게 놓기
		// 최소 이동 횟수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int len = str.length();
		
		// 1. B 오른쪽
		int cnt1=0;
		boolean flag1=false;
		for(int i=len-1; i>=0; i--) {
			if(str.charAt(i)=='R') {
				flag1=true;
				continue;
			}
			if(str.charAt(i)=='B' && flag1) {
				cnt1++;
			}
		}
		
		// 2. R 오른쪽
		int cnt2=0;
		boolean flag2=false;
		for(int i=len-1; i>=0; i--) {
			if(str.charAt(i)=='B') {
				flag2=true;
				continue;
			}
			if(str.charAt(i)=='R' && flag2) {
				cnt2++;
			}
		}
		
		// 3. B 왼쪽
		int cnt3=0;
		boolean flag3=false;
		for(int i=0; i<len; i++) {
			if(str.charAt(i)=='R') {
				flag3=true;
				continue;
			}
			if(str.charAt(i)=='B' && flag3) {
				cnt3++;
			}
		}
		
		// 4. R 왼쪽
		int cnt4=0;
		boolean flag4=false;
		for(int i=0; i<len; i++) {
			if(str.charAt(i)=='B') {
				flag4=true;
				continue;
			}
			if(str.charAt(i)=='R' && flag4) {
				cnt4++;
			}
		}
		
		int ans = Math.min(cnt1, Math.min(cnt2, Math.min(cnt3, cnt4)));
		System.out.println(ans);
		

	}
}
