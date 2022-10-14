package algoConcept;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS와DFS_인접리스트1 {	
	static int N, M, V;
	static Node[] list;
	static boolean[] visited;
	
	static class Node implements Comparable<Node>{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.vertex-o.vertex;
		}
		
	}
	
	private static void dfs(int v) {
		
		visited[V] = true;
		System.out.print(v + " ");
		
		for(Node n = list[v]; n!=null; n = n.next) {
			if(!visited[n.vertex]) {
				dfs(n.vertex);
			}
		}
	}
	
	private static void bfs(int v) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			System.out.print(temp + " ");
			for(Node n = list[temp]; n!=null; n=n.next) {
				if(!visited[n.vertex]) {
					q.offer(n.vertex);
					visited[n.vertex] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("DFSBFSTEST.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new Node[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, list[from]);
			list[to] = new Node(from, list[to]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
		
	}
	
}
