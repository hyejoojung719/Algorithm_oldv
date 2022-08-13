package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2606_바이러스_정혜주 {
	
	static int comp, pairs, cnt;
	static boolean[][] graph;
	static boolean[] isVisited;
	
	public static void dfs(int start) {
		isVisited[start] = true;
		for(int i=1; i<=comp; i++) {
			if(graph[start][i]==true && isVisited[i]==false) {
				dfs(i);
				cnt++;
			}
		}
	}
	...
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 컴퓨터 수 = 노드 숫자 범위
		comp = Integer.parseInt(br.readLine());
		// 컴퓨터 쌍의 수
		pairs = Integer.parseInt(br.readLine());
		
		// 그래프 그리기
		graph = new boolean[comp+1][comp+1];
		// 방문 여부 체크 
		isVisited = new boolean[comp+1];
		
		StringTokenizer st;
		for(int p=0; p<pairs; p++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			graph[p1][p2] = graph[p2][p1] = true;
		}
		
		dfs(1);
		System.out.println(cnt);
		
	}
}
