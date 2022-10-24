package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_13549_숨바꼭질3_re {
	static int N, K;
	static boolean[] visited = new boolean[100002];
//	static int min=Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node>{
		int num;
		int time;
		public Node(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return this.time-o.time;
		}
	}

	
	static void bfs(int node) {
		PriorityQueue<Node> q = new PriorityQueue();
		q.offer(new Node(node, 0));
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			visited[temp.num] = true;
			
			if(temp.num==K) {
				System.out.println(temp.time);
				System.exit(0);
			}
			
			for(int i=0; i<3; i++) {
				if(i==0) {
					// *2
					int num = temp.num*2;
					if(num>=0 && num<=100001 && !visited[num]) {
						q.offer(new Node(num, temp.time));
					}
				}else if(i==1) {
					// -1
					int num = temp.num-1;
					if(num>=0 && num<=100001 && !visited[num]) {
						q.offer(new Node(num, temp.time+1));
					}
				}else {
					// +1
					int num = temp.num+1;
					if(num>=0 && num<=100001 && !visited[num]) {
						q.offer(new Node(num, temp.time+1));
					} 
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
//		System.out.println(min);
	}
}
