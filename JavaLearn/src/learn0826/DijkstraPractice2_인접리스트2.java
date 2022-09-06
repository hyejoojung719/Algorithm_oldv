package learn0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import learn0826.DijkstraPractice2_인접리스트.Node;

public class DijkstraPractice2_인접리스트2 {
	
	static class Node{
		int v,w;
		Node next;
		public Node(int v, int w, Node next) {
			super();
			this.v = v;
			this.w = w;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] dist = new int[V];
		boolean[] visit = new boolean[V];
		Node[] list = new Node[V];
		int start = 0, end = V-1;
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]  = 0;
		
		int min = 0, now =0; 
		for(int i=0; i<V; i++) {
			min = Integer.MAX_VALUE;
			for(int j=0; j<V; j++ ) {
				if(!visit[j] && min > dist[j]) {
					now = j;
					min = dist[j];
				}
			}
			
			visit[now] = true;
			if(end == now) break;
			
			for(Node temp = list[now]; temp != null; temp = temp.next) {
				if(!visit[temp.v] && dist[temp.v] > min + temp.w) {
					dist[temp.v] = min + temp.w;
				}
			}
		}
		System.out.println(dist[end]);
	}
}
