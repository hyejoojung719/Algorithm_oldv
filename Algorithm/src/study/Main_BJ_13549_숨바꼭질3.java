package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_13549_숨바꼭질3 {
	
	static class Point implements Comparable<Point>{
		int num;
		int cnt;
		public Point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			return this.cnt-o.cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Point> pq2 = new PriorityQueue<>();
		
		int time=0;
		pq2.offer(new Point(N, time));
		if(N==0) pq1.offer(1);
		else pq1.offer(N);
		while(!pq2.isEmpty()) {

			int n = pq2.peek().num;
			time = pq2.poll().cnt;
			
			while(true) {
				n = 2*n;
				
				if(n==K) {
					System.out.println(time);
					System.exit(0);
				}
				
				if(n>K*2) break;
				pq1.offer(n);
			}
			
			while(!pq1.isEmpty()) {
				int num = pq1.poll();
				
				int input1 = num+1;
				int input2 = num-1;
				
				if(input1==K || input2==K) {
					System.out.println(time+1);
					System.exit(0);
				}
				
				if(input2>0)pq2.offer(new Point(input2, time+1));
				pq2.offer(new Point(input1, time+1));
				
			}
		}
		
	}
}
