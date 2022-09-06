package learn0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraPractice {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		int[] dist = new int[V];
		boolean[] visit = new boolean[V];
		int[][] graph = new int[V][V];
		int start=0, end=V-1;
		
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				graph[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		int min=0, now=0;
		for (int i = 0; i < V; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < V; j++) {
				if(!visit[j] && min > dist[j]) {
					min = dist[j];
					now = j;
				}
			}
			
			visit[now] = true;
			if(now == end) break;
			
			for(int j=0; j<V; j++) {
				if(!visit[j] && graph[now][j]!=0
						&& dist[j] > min + graph[now][j]) {
					dist[j] = min + graph[now][j];
				}
			}
		}
		System.out.println(dist[end]);
	}
	
}
