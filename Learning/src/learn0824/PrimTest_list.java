package learn0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class PrimTest_list {
	static int N=7; // 정점은 0~6까지
	static int M; // 간선 개수
	
	static List<Node> list = new LinkedList<>();
	
	static boolean[] visited;
	
	static List<Node>[] node;
	
	static int[] minEdge;
	
	static class Node{
		int link;
		int ex;	// 가중치 
		
		public Node(int link, int ex) {
			super();
			this.link = link;
			this.ex = ex;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		
		node = new ArrayList[7];
		for (int i = 0; i < 7; i++) {
			node[i]  = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			
			node[from].add(new Node(to, ex));
			node[to].add(new Node(from, ex));
		}
		
		visited = new boolean[N];
		minEdge = new int[N];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		int result = getMST();
		
		System.out.println(result);
	}
	
	public static int getMST() {
		int result = 0;
		int cnt = 0;
		
		minEdge[0] = 0;
		
		while(cnt < N) {
			// 1. 최소 비용 정점 찾기
			int minV = -1;
			int min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minV = i;
				}
			}
			// 가중치 더하고, 방문체크, 카운트+1
			cnt++;
			result += min;
			visited[minV] = true;
			
			// 2. minEdge 갱신(방문X, 인접체크, 비용비교)
			for (int i = 0; i < node[minV].size(); i++) {
				int to = node[minV].get(i).link;
				if(!visited[to] && node[minV].get(i).ex < minEdge[to]) {
					minEdge[to] = node[minV].get(i).ex;
				}
					// adjMatrix[minv][to] 
			}
		}
		
		return result;
	}
}
