package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10971_외판원순회2_정혜주 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		// 1~N번까지 도시
		// 한 도시를 출발 해 N개의 도시를 모두 거쳐 다시 원래 도시로 돌아오는 순회 여행 경로 계획(한번만 방문 가능)
		// 가장 적은 비용이 드는 여행 경로? 최소 비용 출략

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dfs로 탐색하면서 비용 갱신

		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i,i,0,0,i);
		}

		System.out.println(answer);
	}

	// 순열....? dfs...?
	public static void dfs(int start, int next, int cost, int cnt, int first) {

		if(cnt==N-1) {

			// 여기 조건 추가해야함! (마지막 노드에서 첫노드로 순회 하지 않는 케이스도 고려)
			if(map[start][first]!=0) { 
				cost += map[start][first]; 
				answer = Math.min(answer, cost);
			}
		}

		for(int i=0; i<N; i++) {
			if(!visited[i] && map[start][i]!=0) {
				visited[i] = true;
				cost+=map[start][i];
				dfs(i,i,cost,cnt+1, first);
				cost-=map[start][i];
				visited[i] = false;
			}
		}
	}
}
