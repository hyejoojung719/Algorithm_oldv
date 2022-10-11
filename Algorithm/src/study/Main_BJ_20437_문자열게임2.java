package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_20437_문자열게임2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		final int INF_MAX = Integer.MAX_VALUE;
		final int INF_MIN = Integer.MIN_VALUE;
		
		for (int tc = 0; tc < T; tc++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			// 1. 문자들을 입력 받을 떄 각각 알파벳의 개수를 센다
			// 2. 알파벳 개수가 K개 이상인 알파벳 기준으로 체크
			// 3. 투포인터 이용?
			
			int len = W.length();
			int[] cntArr = new int[26];
			for (int i = 0; i < len; i++) {
				char letter = W.charAt(i);
				cntArr[letter-97]++;
			}

			int ans1=INF_MAX;
			int ans2=INF_MIN;
			
			for (int i = 0; i < len; i++) {
				char letter = W.charAt(i);
				int cnt=cntArr[letter-97];
				if(cnt>=K) {
					int left=i;
					int right=len-1;
					// 해당 알파뱃 만날 떄 마다 cnt 1씩 감소
					// K개 되는 순간 길이 반환
					while(left!=right) {
						if(W.charAt(right)==letter) {
							if(cnt==K) {
								
//								for (int j = left; j <= right; j++) {
//									System.out.print(W.charAt(j));
//								}
								ans1=Math.min(ans1, right-left+1);
								ans2=Math.max(ans2, right-left+1);
//								System.out.println();
//								System.out.println("ans1 = " + ans1);
//								System.out.println("ans2 = " + ans2);
								break;
							}
							cnt--;
						}
						right--;
					}
					cntArr[letter-97]--;
				}
			}
			
			if(ans1==INF_MAX || ans2==INF_MIN) {
				sb.append("-1"+"\n");
			}
			else {
				sb.append(ans1 + " " + ans2 + "\n");
			}
		}
		System.out.println(sb);
	}
}
