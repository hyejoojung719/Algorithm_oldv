package algoConcept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS와DFS_인접리스트 {
	static int N, M, V;
	static List<Integer>[] list;
	static boolean[] visited;
	
	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<list[v].size(); j++) {
				if(!visited[i] && i == list[v].get(j)) {
					dfs(list[v].get(j));
				}
			}
		}
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		System.out.print(v + " ");
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i=1; i<=N; i++) {
				for (int j = 0; j < list[temp].size(); j++) {
					if(!visited[i] && i == list[temp].get(j)) {
						q.offer(i);
						visited[i] = true;
						System.out.print(i + " ");
					}
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
		
	}
}
