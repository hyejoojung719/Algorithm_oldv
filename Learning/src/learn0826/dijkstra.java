package learn0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dijkstra {
	private static int[][] graph;
	private static int[] dist;
	static boolean[] visited;
	static int start, end;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		dist = new int[N];
		visited = new boolean[N];
		start = 0; end = N-1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 시작 포인트는 0
		dist[start] = 0;
		
		int min=0, now=0;
		for(int i=0; i<N; i++) {
			// 방문하지 않은 정점들 중 최소 가중치 선택!!
			min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					now = j;
				}
			}
			
			visited[now] = true; 	// 방문 처리
			if(now == end) break; // 도착점과 선택정점이 같으면 탈출
			
			// now 정점을 경유지로 하여 갈 수 있는 다른 방문하지 않은 정점 처리
			for(int j=0; j<N; j++) {
				if(!visited[j] && graph[now][j]!=0
						&& dist[j] > graph[now][j] + min) {
					dist[j] = graph[now][j] + min;
				}
			}
		}
		System.out.println(dist[end]);
	}
	
}
