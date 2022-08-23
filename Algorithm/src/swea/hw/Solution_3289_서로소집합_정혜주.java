package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_정혜주 {
	static int n,m;
	static boolean[][] graph;
	static boolean[] isVisited;
	static List<Integer> list;
	
	public static boolean dfs(int set1, int set2) {
		isVisited[set1] = true;
		list.add(set1);
		
		for(int i=1; i<=n; i++) {
			if(!isVisited[i] && graph[set1][i]==true) {
				isVisited[i] = true;
				list.add(i);
				if(list.contains(set2)) return true;
				if(dfs(i, set2)) return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		// 0 : 집합 합치기
		// 1 : 같은 집합인지 확인 -> 결과값 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			graph = new boolean[n+1][n+1];
			
			String answer = "";
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cal = Integer.parseInt(st.nextToken());
				int set1 = Integer.parseInt(st.nextToken());
				int set2 = Integer.parseInt(st.nextToken());
				
				if(cal==1) {
					// 같은 집합인지 확인
					isVisited = new boolean[n+1];
					list = new ArrayList<>();
					if(dfs(set1, set2)) answer+="1";
					else answer+="0";
				}else {
					// 연결(합집합)
					graph[set1][set2] = true; 
					graph[set2][set1] = true; 
				}
			}
			
			System.out.println("#"+tc+" "+answer);
			
		}
	}
}
