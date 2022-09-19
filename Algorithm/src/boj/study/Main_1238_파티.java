package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	static int N, M, X;
	static Node[] list;
	static Node[] reverseList;
	static boolean[] visited;
	static int[] dist;
	static int[] reversedist;
	
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
		// N개의 숫자로 구분된 마을에 한 명의 학생이 살 고 있다 
		// X번 마을에 모여 파티
		// 마을 사이에는 M개의 다리와, Ti시간 소비(비용) 
		// 갔다 다시 집으로 와야함
		// 최단 시간 
		// 다리는 단방향
		// 가장 많은 시간을 소비하는 학생...?
		
		// N M X
		// i시작, 끝점, Ti
		// 단방향이므로 자기자신으로 돌아오는 도로는 X
		
		// 우선순위 큐로 해야 시간초과 X
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// MST -> 다익스트라..
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// V
		M = Integer.parseInt(st.nextToken());	// E
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		reversedist = new int[N+1];
		list = new Node[N+1];
		reverseList = new Node[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
			reverseList[to] = new Node(from, weight, list[to]);
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(reversedist, Integer.MAX_VALUE);
		
		System.out.println(dist[1]);
		
		
	}
	
	private static void mst(Node[] list, int[] dist) {
		visited = new boolean[N+1];
		int min = 0, now =0; 
		for(int i=1; i<=N; i++) {
			min = Integer.MAX_VALUE;
			for(int j=1; j<=N; j++ ) {
				if(!visited[j] && min > dist[j]) {
					now = j;
					min = dist[j];
				}
			}
			
			visited[now] = true;
//			if(start == now) break;
			
			for(Node temp = list[now]; temp != null; temp = temp.next) {
				if(!visited[temp.v] && dist[temp.v] > min + temp.w) {
					dist[temp.v] = min + temp.w;
				}
			}
		}
	}
}
