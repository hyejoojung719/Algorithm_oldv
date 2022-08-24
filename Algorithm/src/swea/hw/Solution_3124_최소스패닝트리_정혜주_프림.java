package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우리가 풀던 방식으로 하면 시간복잡도가 V^2
// 
public class Solution_3124_최소스패닝트리_정혜주_프림 {
	
	static int V, E;
//	static int[] minEdge;
	static boolean[] visited;
	static List<Node> list;
	static List<Node>[] nodes;
	
	static class Node {
		int link;
		int ex;
		
		public Node(int link, int ex) {
			super();
			this.link = link;
			this.ex = ex;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
//			minEdge = new int[V+1];
			visited = new boolean[V+1];
			list = new ArrayList<>();
			nodes = new List[V+1];
			
//			Arrays.fill(minEdge, Integer.MAX_VALUE);
			
			for(int i=0; i<V+1; i++) {
				nodes[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int ex = Integer.parseInt(st.nextToken());
				
				nodes[from].add(new Node(to, ex));
				nodes[to].add(new Node(from, ex));
			}
			
			int result = getMST();
			sb.append("#"+tc+" "+result+"\n");
		}
		System.out.println(sb);
	}
	
	public static int getMST() {
		int result = 0;
		int cnt = 0;
		
		
		while(cnt<V) {
			int minV = -1;
			int min = Integer.MAX_VALUE;
			
			// pq에 인접한 가중치들을 담기 
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i=1; i<=V; i++) {
				
			}
			
			visited[minV] =  true;
			cnt++;
			result += min;
		}
		
		return result;
	}
}
