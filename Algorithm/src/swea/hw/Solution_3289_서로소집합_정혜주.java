package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_정혜주 {
	static int n,m;
	static int[] parents;	// 부모 원소 관리
	
	public static void main(String[] args) throws Exception{
		// 0 : 집합 합치기
		// 1 : 같은 집합인지 확인 -> 결과값 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			for(int i=0; i<=n; i++) {
				parents[i] = i;	
			}
			
			String answer ="";
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cal = Integer.parseInt(st.nextToken());
				int set1 = Integer.parseInt(st.nextToken());
				int set2 = Integer.parseInt(st.nextToken());
				
				if(cal==1) {
					if(findSet(set1)==findSet(set2)) answer += "1";
					else answer += "0";
				}else {
					union(set1, set2);
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
		
	}
	
	public static boolean union(int set1, int set2) {
		// 대표원소 기준으로 합치기
		int Root1 = findSet(set1);
		int Root2 = findSet(set2);
		if(Root1 == Root2) return false;	// 이미 동일한 집합
		
		parents[Root2] = Root1;
		return true;
	}
	
	public static int findSet(int set) {
		// 대표원소 찾기
		if(set == parents[set]) return set;
		else {
			return parents[set] = findSet(parents[set]);
		}
		
	}
}
