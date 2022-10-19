package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_BJ_20437_문자열게임2_다른풀이 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			
			List<Integer>[] cntArr = new ArrayList[26];
			for(int i=0; i<26; i++) {
				cntArr[i] = new ArrayList<>();
			}
			
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());

			// 문자들 위치를 담은 index 리스트에 저장
			// index간 차이를 계산해서 최대 최소 구하기

			int len = W.length();
			
			for (int i = 0; i < len; i++) {
				char letter = W.charAt(i);
				cntArr[letter-97].add(i);
			}

			int ans1 = Integer.MAX_VALUE;
			int ans2 = Integer.MIN_VALUE;

			for(int i=0; i<W.length(); i++) {
				int index = W.charAt(i)-97;
				int size = cntArr[index].size();
				if(size>=K) {
					for (int j = 0; j+K <= size; j++) {
						ans1 = Math.min(ans1, cntArr[index].get(j+K-1)-cntArr[index].get(j)+1);
						ans2 = Math.max(ans2, cntArr[index].get(j+K-1)-cntArr[index].get(j)+1);
					}
				}
			}
			
			if(ans1==Integer.MAX_VALUE || ans2==Integer.MIN_VALUE) {
				sb.append("-1"+"\n");
			}
			else {
				sb.append(ans1 + " " + ans2 + "\n");
			}
		}
		System.out.println(sb);
	}
}