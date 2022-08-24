package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_정혜주_크루스칼 {
	
	static int V, E;
	static List<Node> list;
	static List<Node>[] nodes;
	static PriorityQueue<Integer> q;
	static int[] parents;
	
	static class Node {
		int from;
		int to;
		int ex;
		
		public Node(int from, int to, int ex) {
			super();
			this.from = from;
			this.to = to;
			this.ex = ex;
		}
	}
	
	// 크루스칼 시간복잡도 ElogE (E : 간선 수)
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			nodes = new List[V+1];
			q = new PriorityQueue<>();
			
			for(int i=0; i<V+1; i++) {
				nodes[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int ex = Integer.parseInt(st.nextToken());
				
				nodes[from].add(new Node(from, to, ex));
				nodes[to].add(new Node(to, from, ex));
				q.offer(ex);
			}
			
		}
//		System.out.println(sb);
	}
	
	public static boolean union(int from, int to) {
		// 대표원소 기준으로 합치기
		int Root1 = findSet(from);
		int Root2 = findSet(to);
		if(Root1 == Root2) return false;	// 이미 동일한 집합
		
		parents[Root2] = Root1;
		return true;
	}
	
	public static int findSet(int set) {
		// 대표원소 찾기
		if(set == parents[set]) return set;
		else {
			return parents[set] = findSet(parents[set]);
		}
		
	}
}
