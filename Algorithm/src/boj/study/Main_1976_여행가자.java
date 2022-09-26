package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
	static int[] parent;
	static int N, M;

	// 분리 집합 == 서로소 집합
	public static void main(String[] args) throws Exception{
		// 도시의 수 N
		// 여행 계획에 속한 도시들의 수 M
		// N개의 줄에 N개의 정수가 주어짐(연결 정보)
		// 마지막 줄에는 여행 계획(1~N번)
		// 순서대로 도시를 방문하는 게 가능한지 판별 YES, NO

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			makeSet(i);
		}

		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		for(int i=0; i<M-1; i++) {
			int t = Integer.parseInt(st.nextToken());
			
			if(findSet(x) != findSet(t)) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	
	private static void makeSet(int x) {
		parent[x] = x;
	}
	
	private static int findSet(int x) {
		if(x == parent[x]) {
			return x;
		}else {
			parent[x] = findSet(parent[x]);
			
			return parent[x];
		}
	}
	
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px!=py) {
			parent[py] = px;
		}
	}
}
