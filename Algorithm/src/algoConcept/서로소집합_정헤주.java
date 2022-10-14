package algoConcept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소집합_정헤주 {
	static int[] parent;
	
	public static void makeSet(int x) {
		parent[x] = x;
	}
	
	public static void union(int x, int y) {
		int rootX = findSet(x);
		int rootY = findSet(y);
		
		if(rootX == rootY) {
			return;
		}else {
			parent[rootY] = rootX;
		}
	}
	
	public static int findSet(int x){
		if(parent[x] == x) return x;
		else {
			return parent[x] = findSet(parent[x]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			sb.append("#"+tc+" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				makeSet(i);
			}
			
			String answer = "";
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(cal == 0) {
					union(x, y);
				}else {
					if(findSet(x)==findSet(y)) {
						answer += "1";
					}
					else {
						answer += "0";
					}
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}
