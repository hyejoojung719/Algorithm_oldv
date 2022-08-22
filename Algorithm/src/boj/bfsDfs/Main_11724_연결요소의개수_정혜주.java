package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수_정혜주 {
	static int N,M;
	static boolean[][] graph;
	static boolean[] isVisited;
	static int cnt;
	
	public static int massCnt(int v) {
		for(int i=0; i<N; i++) {
			if(isVisited[i]==false) {
				dfs(i);
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void dfs(int v) {
		isVisited[v] = true;
		
		for(int i=0; i<N; i++) {
			if(graph[v][i] && !isVisited[i]) {
				dfs(i);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a][b]=graph[b][a]=true;
		}
		
		isVisited = new boolean[N];
		System.out.println(massCnt(0));
		
	}
}
