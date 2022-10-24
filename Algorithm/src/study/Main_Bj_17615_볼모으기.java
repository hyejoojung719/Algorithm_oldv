package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_Bj_17615_볼모으기 {
	public static void main(String[] args) throws Exception {
		// 같은 색 끼리 인접하게 놓기
		// 최소 이동 횟수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int len = str.length();
		
		int scnt=0;
		int sch = str.charAt(0);
		for (int i = 0; i < len; i++) {
			if(sch!=str.charAt(i)) {
				scnt=i;
				break;
			}
		}

		int ecnt=0;
		int ech = str.charAt(len-1);
		for (int i = len-1; i >= 0; i--) {
			if(ech!=str.charAt(i)) {
				ecnt=len-1-i;
				break;
			}
		}

		int ans=0;
		if(scnt>=ecnt) {
			// 맨 처음부터 시작
			int start = scnt;
			int end = len-1;
			wh: while(true) {
				System.out.println("start : " + start + ", end : " + end);
				if(str.charAt(start)!=sch) {
					while(true) {
						if(str.charAt(end)==sch) {
							ans++;
							end--; 
							break;
						}
						if(start==end) {
							break wh;
						}
						end--;
					}
				}
				start++;
			}
		}else {
			// 맨 끝부터 시작
			int end = len-1-ecnt;
			int start = 0;
			wh: while(true) {
				System.out.println("start : " + start + ", end : " + end);
				if(str.charAt(end)!=ech) {
					while(true) {
						if(str.charAt(start)==ech) {
							ans++;
							start++; 
							break;
						}
						if(start==end) {
							break wh;
						}
						start++;
						System.out.println("		start : " + start + ", end : " + end);
					}
				}
				end--;
			}
		}
		
		System.out.println(ans);

	}
}
