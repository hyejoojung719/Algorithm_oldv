package algoConcept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS와DFS_인접행렬 {
	static int N,M,V;
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && graph[v][i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i=1; i<=N; i++) {
				if(!visited[i] && graph[temp][i]) {
					visited[i] = true;
					q.offer(i);
					System.out.print(i + " ");
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());	// 탐색 시작 정점
		
		graph = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
	}
}
