package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_정혜주 {
	static int N, M;
	static boolean[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1~N번까지 학생들 중에서 두 학생의 키를 비교한 결과가 일부 주어짐
		// 키는 모두 다르다 
		// a번 학생의 키가 b학생의 키보다 작으면 a->b
		// 자신의 키가 몇 번째인지 알 수 있는 학생 수 출력
		
		// hint : 전체 학생 수 -1 = 나보다 작은 사람 +나보다 큰사람
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			int ans=0;
			graph = new boolean[N+1][N+1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a][b] = true;
			}
			
			for (int i = 1; i <=N ; i++) {
				visited = new boolean[N+1];
				int smallCnt = smaller(i);
				
				visited = new boolean[N+1];
				int largeCnt = larger(i);
				
				if(N-1 == smallCnt+largeCnt) ans++;
			}
			
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	private static int smaller(int v) {
		int ans=0;
		visited[v] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i=1; i<=N; i++) {
				if(graph[temp][i] && !visited[i]) {
					visited[i]=true;
					ans++;
					q.offer(i);
				}
			}
		}
		
		return ans;
	}
	
	private static int larger(int v) {
		int ans=0;
		visited[v] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i=1; i<=N; i++) {
				if(graph[i][temp] && !visited[i]) {
					visited[i]=true;
					ans++;
					q.offer(i);
				}
			}
		}
		
		return ans;
	}
}
