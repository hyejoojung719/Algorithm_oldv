package AlgoConcept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로_정혜주 {
	
	static class Node {
		int to;
		int weight;
		Node next;
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		int to;
		int totalWeight;
		public Vertex(int to, int totalWeight) {
			super();
			this.to = to;
			this.totalWeight = totalWeight;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.totalWeight - o.totalWeight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		Node[] list = new Node[V+1];
		int[] dist = new int[V+1];
		final int INF = Integer.MAX_VALUE; 
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
		}
		
		Arrays.fill(dist, INF);
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		dist[start] = 0;
		pq.offer(new Vertex(start, dist[start]));
		
		while(!pq.isEmpty()) {
			Vertex temp = pq.poll();
			
			if(visited[temp.to]) continue;
			
			visited[temp.to] = true;
			
			//System.out.println(temp.totalWeight);
			
			for(Node n = list[temp.to]; n != null; n = n.next) {
				if(!visited[n.to]) {
					if(dist[n.to] > temp.totalWeight + n.weight) {
						dist[n.to] = temp.totalWeight + n.weight;
						pq.offer(new Vertex(n.to, dist[n.to]));
					}
				}
			}
		}
		
		for (int i = 1; i <= V; i++) 
		{
			if(dist[i]==INF) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
			
		}
	}
}
