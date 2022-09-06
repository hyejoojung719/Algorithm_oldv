package learn0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraPractice2_인접리스트 {
	
	static class Node{
		int v;
		int weight;
		Node next;
		public Node(int v, int weight, Node next) {
			super();
			this.v = v;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		// 정점 개수
		int V = Integer.parseInt(st.nextToken());
		 
		// 간선 개수
		int E = Integer.parseInt(st.nextToken());
		
		int start=0;
		int end=V-1;
		final int INFINITY = Integer.MAX_VALUE;
		
		Node[] adjList = new Node[V];
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		Arrays.fill(dist, INFINITY);
		dist[start] = 0;
		
		int min=0, now=0;
		for(int i=0; i<V; i++) {
			min = INFINITY;
			for(int j=0; j<V; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					now = j;
				}
			}
			visited[now] = true;	// 방문 처리
			if(now == end) break;
			
			for(Node temp = adjList[now]; temp != null; temp=temp.next) {
				if(!visited[temp.v] && dist[temp.v] > min+temp.weight) {
					dist[temp.v] = min + temp.weight;
				}
			}
		}
		System.out.println(dist[end]);
	}
}
