package algoConcept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_최소스패닝트리_kruskal {
	static int V, E;
	static int[] parent;
	static Edge[] edges;
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from,int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	public static void makeSet(int x) {
		parent[x] = x;
	}
	
	public static int findSet(int x) {
		if(x == parent[x]) return x;
		else {
			return parent[x] = findSet(parent[x]);
		}
	}
	
	public static boolean union(int x, int y) {
		int rootX = findSet(x);
		int rootY = findSet(y);
		
		if(rootX == rootY) {
			return false;
		}else {
			parent[rootY] = rootX;
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 크루스칼 알고리즘 : 간선 비용이 낮은 애들부터 고른다!!!
		// 서로소 집합을 이용한당...
		// V : 정점 개수
		// E : 간선 개수
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[V+1];
			
			// 간선을 고르는거라서 간선 정보 담을 배열을 만들자
			edges = new Edge[E];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edges[i] = new Edge(from, to, weight);
			}
			
			for(int i=0; i<V+1; i++) {
				makeSet(i);
			}
			
			Arrays.sort(edges);
			
			long answer = 0;
			int node = 1;
			
			for(Edge e : edges) {
				if(union(e.from, e.to)) {
					answer += e.weight;
					node++;
				}
				if(node == V) break;
			}
			
			System.out.println("#" + tc+ " " + answer);
		}
		
		
	}
}
