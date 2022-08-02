package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리복구하기_정혜주 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=test_case; tc++) {
			
			String bit = br.readLine();
			
			char[] org = bit.toCharArray();
			int cnt = 0;
			
			for(int idx=org.length-1; idx>=0; idx--) {
				// 왼쪽 숫자랑 같은지 다른지 비교
				if((idx!=0) && (org[idx]!=org[idx-1])) {
					// 다르면 왼쪽 숫자로 통일
					for(int i=idx; i<org.length; i++ ) {
						org[i] = org[idx-1];
					}
					cnt++;
				}else if(idx==0 && org[idx]=='1'){
					cnt++;
				}else {
					// 같으면 pass
					continue;
				}
			}
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
}
