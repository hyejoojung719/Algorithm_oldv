package AlgoConcept;

import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Solution_최소스패닝트리_primPQ {
	static int V, E;
	static Node[] list;
	static boolean[] visited;
	
	static class Node{
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
	
	public static void main(String[] args) throws Exception{
		// 임의의 정점에서 시작하여 인접한 간선들 중 비용이 작은 간선을 고른다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new Node[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
			list[to] = new Node(from, weight, list[to]);
		}
		
		visited = new boolean[V+1];
		
		System.out.println(getMst());
		
	}

	static class Vertex implements Comparable<Vertex>{
		int to;
		int weight;
		
		public Vertex(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int getMst() {
		int result=0;
		int cnt = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1,0));
		
		while(!pq.isEmpty()) {
			Vertex temp = pq.poll();
			
			if(visited[temp.to]) continue;
			
			visited[temp.to] = true;
			result += temp.weight;
			cnt++;
			
			if(cnt==V) break;
			
			for(Node n = list[temp.to]; n != null ; n = n.next) {
				if(!visited[n.to]) {
					pq.offer(new Vertex(n.to, n.weight));
				}
			}
		}
		
		return result;
	}
}
