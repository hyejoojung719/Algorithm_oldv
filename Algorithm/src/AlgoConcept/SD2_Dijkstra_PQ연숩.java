package AlgoConcept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

==> 8

4 
0 94 53 16 
79 0 24 18 
91 80 0 98 
26 51 92 0
==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

==> 14
 */
/**
 * @author taeheekim
 */
public class SD2_Dijkstra_PQ연숩 {
	
	static class Node{
		int to, weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int to, weight;

		public Vertex(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = 0, end = V-1;
		final int INFINITY = Integer.MAX_VALUE;
		
		Node[] list = new Node[V];
		int[] dist = new int[V];
		boolean[] visit = new boolean[V];
		
		for(int i=0; i<E; i++) {
			st= new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
		}
		
		Arrays.fill(dist, INFINITY);
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new  Vertex(start, dist[start]));
		
		Vertex current = null;
		while(!pq.isEmpty()) {
			
			// 방문하지 않은 정점들 중 최소가중치 정점 선택
			current = pq.poll();
			if(visit[current.to]) continue;
			
			visit[current.to] = true;
			if(current.to == end) break; 
			
			for(Node n = list[current.to]; n!=null; n = n.next) {
				if(!visit[n.to]) {
					if(dist[n.to] > current.weight + n.weight) {
						dist[n.to] = current.weight + n.weight;
						pq.offer(new Vertex(n.to, dist[n.to]));
					}
				}
			}
		}
		System.out.println(dist[end]);
	}

}