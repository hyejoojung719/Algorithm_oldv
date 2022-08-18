package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DfS와BFS_정혜주 {
	static int n, m, v;
	static boolean[][] graph;
	static boolean[] isVisited;
	
	public static void dfs(int v) {
		isVisited[v] = true;
		System.out.print(v + " ");
		for(int i=1; i<=n; i++) {
			if(graph[v][i]==true && !isVisited[i]) dfs(i);
		}
	}
	
	public static void bfs(int v) {
		isVisited[v] = true;
		System.out.print(v + " ");
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0; i<=n; i++) {
				if(graph[temp][i]==true && !isVisited[i]) {
					isVisited[i] = true;
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
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v= Integer.parseInt(st.nextToken());
		
		graph = new boolean[n+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = true;
		}
		
		isVisited = new boolean[n+1];
		dfs(v);
		System.out.println();
		isVisited = new boolean[n+1];
		bfs(v);
		
	}
}
