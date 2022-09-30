package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수_정혜주 {
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine()); 
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			for(int i=1; i<=N; i++) {
				parents[i] = i;
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i=1; i<= N; i++) {
				set.add(findParent(i));
			}
			
			sb.append("#"+tc+" "+set.size()+"\n");
		}
		System.out.println(sb);
	}
	
	public static void  union(int a, int b) {
		int root_a = findParent(a);
		int root_b = findParent(b);
		// 대표 원소 찾기 
		
		if(root_a < root_b) parents[root_b] = root_a;
		else parents[root_a] = root_b;
	}
	
	public static int findParent(int c) {
		if(parents[c] == c) return c;	// 대표원소가 자기자신이라면 return
		else return parents[c] = findParent(parents[c]); // 자기 자신이 아니라면 대표원소 찾을 때까지 반복
	}
}
