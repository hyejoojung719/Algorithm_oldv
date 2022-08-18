package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2606_바이러스_정혜주_dfs {
	
	static int com_cnt, pairs;
	static boolean[][] graph;
	static boolean[] isVisited;
	static int cnt;
	
	//dfs로 구현해보기
	private static void dfs(int v) {
		isVisited[v] = true;
		
		for(int i=1; i<=com_cnt; i++) {
			if(!isVisited[i] && graph[v][i]==true) {
				dfs(i);
				cnt++;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		com_cnt =  Integer.parseInt(br.readLine());
		pairs = Integer.parseInt(br.readLine());
		
		graph = new boolean[com_cnt+1][com_cnt+1];
		StringTokenizer st;
		for(int i=0; i<pairs; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 인접 행렬로 그래프 구현하기
			graph[a][b]=true;
			graph[b][a]=true;
		}
		
		isVisited = new boolean[com_cnt+1];
		dfs(1);
		System.out.println(cnt);
	}
}
