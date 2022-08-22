package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1238_Contact_정혜주 {
	static boolean[][] graph;
	static boolean[] isVisited;
	static Stack<Integer> stack;
	
	public static void bfs(int start) {
		isVisited = new boolean[101];
		Queue<Integer> q = new LinkedList<>();
		stack = new Stack<>();
		isVisited[start] = true;
		q.offer(start);
		 
		while(!q.isEmpty()) {
			int size = q.size();
			int max = 0;
			boolean flag=false;
			
			for(int i=0; i<size; i++) {
				int v = q.poll();
				for(int j=1; j<=100; j++) {
					if(graph[v][j] && !isVisited[j]) {
						if(!flag) flag = true;
						q.offer(j);
						isVisited[j]=true;
						max = Math.max(max, j);
					}
				}
			}
			if(flag) stack.add(max);
		}
	}
	
	public static void main(String[] args) throws Exception{
		// 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람?
		
		// 화살표 - 연락인 가능한 방향
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			graph = new boolean[101][101];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<L/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from][to] = true;
				
			}
			
			
			bfs(start);
			System.out.println("#"+tc+" "+stack.pop());
		}
	}
}
