package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15961_회전초밥_정혜주 {
	public static void main(String[] args) throws IOException {
		// ip
		// 회전 초밥 벨트 접시 수 N, 초밥 가짓수 d, 연속해서 먹는 접시 수 k, 쿠폰 번호 c
		// N개 줄 만큼 초밥 종률 나타내는 번호 1~d까지가 주어짐
		
		// op : 주어진 회전 초밥 벨트에서 먹을 수 있는 초밥의 가짓수의 최댓값?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushies = new int[N];
		for (int i = 0; i < N; i++) {
			sushies[i] = Integer.parseInt(br.readLine());
		}
		
		int[] ate = new int[d+1];
		int cnt=0;
		for(int i=0; i<k; i++) {
			int idx=sushies[i];
			if(ate[idx]==0) {
				cnt++;
			}
			ate[idx]++;
			
		}
		

		
		int ans;
		if(ate[c]==0) ans = cnt+1;
		else ans = cnt;
		
		int right = k, left=0;
		while(true) {
			int in = sushies[right++];
			int out = sushies[left++];
			
			if(ate[out]-1==0) {
				cnt--;
			}
			ate[out]--;
            
			if(ate[in]==0) {
				cnt++;
			}
			ate[in]++;
			
			if(ate[c]==0) { 
				ans=Math.max(ans, cnt+1);
			}else {
				ans=Math.max(ans, cnt);
			}
			
			if(right==N) right=0;
			if(right==k) break;
		}
		
		System.out.println(ans);
	}
}
